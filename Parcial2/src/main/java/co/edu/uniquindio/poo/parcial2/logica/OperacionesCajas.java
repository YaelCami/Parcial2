package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Pila;
import co.edu.uniquindio.poo.parcial2.modelo.Caja;

public class OperacionesCajas {

    public static boolean retirarCaja(
            Pila<Caja> pila, String codigo) {

        if (pila.estaVacia()) {
            return false;
        }

        Pila<Caja> auxiliar = new Pila<>();
        boolean encontrada = false;
        int valorRetirado = 0;

        // Buscar la caja sin perder los elementos.
        while (!pila.estaVacia()) {
            Caja caja = pila.desapilar();
            auxiliar.apilar(caja);

            if (caja.getCodigo().equals(codigo)) {
                encontrada = true;
                valorRetirado = caja.getValor();
            }
        }

        // Restaurar la pila, omitiendo la caja buscada.
        while (!auxiliar.estaVacia()) {
            Caja caja = auxiliar.desapilar();

            if (!encontrada
                    || !caja.getCodigo().equals(codigo)) {
                pila.apilar(caja);
            }
        }

        // Si no existe, la pila queda como estaba.
        if (!encontrada) {
            return false;
        }

        Pila<Caja> impares = new Pila<>();
        Pila<Caja> pares = new Pila<>();

        int posicion = 1;

        // Clasificar según las posiciones desde la cima.
        while (!pila.estaVacia()) {
            Caja caja = pila.desapilar();

            if (posicion % 2 == 1) {
                impares.apilar(caja);
            } else {
                pares.apilar(caja);
            }

            posicion++;
        }

        // Recuperar el orden relativo de cada grupo.
        impares = invertir(impares);
        pares = invertir(pares);

        Pila<Caja> resultado = new Pila<>();

        // Primero construir el grupo que quedará abajo.
        if (valorRetirado % 2 == 0) {
            agregarGrupo(pares, resultado);
            agregarGrupo(impares, resultado);
        } else {
            agregarGrupo(impares, resultado);
            agregarGrupo(pares, resultado);
        }

        // Dejar el resultado en la pila original.
        Pila<Caja> auxiliarFinal = invertir(resultado);

        while (!auxiliarFinal.estaVacia()) {
            pila.apilar(auxiliarFinal.desapilar());
        }

        return true;
    }

    private static Pila<Caja> invertir(Pila<Caja> pila) {
        Pila<Caja> invertida = new Pila<>();

        while (!pila.estaVacia()) {
            invertida.apilar(pila.desapilar());
        }

        return invertida;
    }

    private static void agregarGrupo(
            Pila<Caja> grupo, Pila<Caja> resultado) {

        Pila<Caja> auxiliar = invertir(grupo);

        while (!auxiliar.estaVacia()) {
            resultado.apilar(auxiliar.desapilar());
        }
    }
}
