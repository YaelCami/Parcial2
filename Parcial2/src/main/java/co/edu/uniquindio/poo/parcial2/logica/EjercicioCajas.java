package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Pila;
import co.edu.uniquindio.poo.parcial2.modelo.Caja;

public class EjercicioCajas {

    public static void mostrarPila(Pila<Caja> pila) {
        Pila<Caja> auxiliar = new Pila<>();

        System.out.print("(Cima) -> ");

        while (!pila.estaVacia()) {
            Caja caja = pila.desapilar();
            System.out.print(caja + " -> ");
            auxiliar.apilar(caja);
        }

        System.out.println(" -> ");
        System.out.println("(Fondo)");

        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }
    }

    public static void main(String[] args) {
        Pila<Caja> pila = new Pila<>();

        // Se agregan en el orden indicado en el enunciado.
        pila.apilar(new Caja("C1", 2));
        pila.apilar(new Caja("C2", 4));
        pila.apilar(new Caja("C3", 6));
        pila.apilar(new Caja("C4", 8));
        pila.apilar(new Caja("C5", 3));
        pila.apilar(new Caja("C6", 9));
        pila.apilar(new Caja("C7", 5));

        System.out.println("Pila inicial:");
        mostrarPila(pila);

        String[] codigos = {"C3", "C4", "C7"};

        for (String codigo : codigos) {
            boolean retirado =
                    co.edu.uniquindio.poo.parcial2.logica.OperacionesCajas.retirarCaja(pila, codigo);

            System.out.println("\nRetiro de " + codigo);
            System.out.println("Retorno: " + retirado);
            mostrarPila(pila);
        }

        System.out.println("\nPila final:");
        mostrarPila(pila);
    }
}
