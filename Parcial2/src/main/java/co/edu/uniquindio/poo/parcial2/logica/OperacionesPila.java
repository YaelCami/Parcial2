package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Pila;

public class OperacionesPila {
    public static <T> Pila<T> obtenerSegmento(
            Pila<T> pila, int inicio, int fin) {

        Pila<T> resultado = new Pila<>();

        // Validar las posiciones solicitadas
        if (pila == null) {
            return resultado;
        }

        int tamanio = pila.cantidadElementos();

        if (inicio < 1 || inicio > fin || fin > tamanio) {
            return resultado;
        }

        Pila<T> auxiliar = new Pila<>();
        Pila<T> segmentoInvertido = new Pila<>();

        int posicion = 1;

        // Recorrer la pila y guardar los elementos seleccionados
        while (!pila.estaVacia()) {
            T elemento = pila.desapilar();

            if (posicion >= inicio && posicion <= fin) {
                segmentoInvertido.apilar(elemento);
            }

            auxiliar.apilar(elemento);
            posicion++;
        }

        // Restaurar la pila original
        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }

        // Construir el resultado con el orden correcto
        while (!segmentoInvertido.estaVacia()) {
            resultado.apilar(segmentoInvertido.desapilar());
        }

        return resultado;
    }
}
