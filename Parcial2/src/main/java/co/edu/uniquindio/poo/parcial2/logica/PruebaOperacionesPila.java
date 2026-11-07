package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Pila;

public class PruebaOperacionesPila {
    public static void main(String[] args) {

        System.out.println("--- CASOS LIMITE ---");

        // Caso 1: inicio igual a fin
        Pila<String> caso1 = OperacionesPila.obtenerSegmento(
                crearPila(), 3, 3);
        System.out.println("Caso 1 (3, 3):");
        imprimirPila(caso1);

        // Caso 2: toda la pila
        Pila<String> caso2 = OperacionesPila.obtenerSegmento(
                crearPila(), 1, 6);
        System.out.println("Caso 2 (1, 6):");
        imprimirPila(caso2);

        // Caso 3: inicio menor que 1
        Pila<String> caso3 = OperacionesPila.obtenerSegmento(
                crearPila(), 0, 3);
        System.out.println("Caso 3 (0, 3):");
        imprimirPila(caso3);

        // Caso 4: inicio mayor que fin
        Pila<String> caso4 = OperacionesPila.obtenerSegmento(
                crearPila(), 4, 2);
        System.out.println("Caso 4 (4, 2):");
        imprimirPila(caso4);

        // Caso 5: fin supera el tamaño
        Pila<String> caso5 = OperacionesPila.obtenerSegmento(
                crearPila(), 2, 7);
        System.out.println("Caso 5 (2, 7):");
        imprimirPila(caso5);
    }

    // Crea una pila nueva para cada prueba
    private static Pila<String> crearPila() {
        Pila<String> pila = new Pila<>();

        pila.apilar("A1");
        pila.apilar("A2");
        pila.apilar("A3");
        pila.apilar("A4");
        pila.apilar("A5");
        pila.apilar("A6");

        return pila;
    }

    // Imprime los elementos desde el tope
    private static void imprimirPila(Pila<String> pila) {
        if (pila.estaVacia()) {
            System.out.println("Pila vacia");
            return;
        }

        while (!pila.estaVacia()) {
            System.out.println(pila.desapilar());
        }
    }
}
