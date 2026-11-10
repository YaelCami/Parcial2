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

        System.out.println("\n--- CASOS DEL ENUNCIADO ---");

        // Ejemplo del enunciado: inicio = 2 y fin = 4 -> A5 -> A4 -> A3
        Pila<String> original = crearPila();
        Pila<String> ejemplo = OperacionesPila.obtenerSegmento(original, 2, 4);
        System.out.println("Ejemplo del enunciado (2, 4): " + texto(ejemplo));
        System.out.println("Esperado:                     A5 -> A4 -> A3");

        // La pila original debe quedar con los mismos elementos en el mismo orden.
        System.out.println("Pila original despues:        " + texto(original));
        System.out.println("Esperado:                     A6 -> A5 -> A4 -> A3 -> A2 -> A1");
        System.out.println("Cantidad en la original:      "
                + original.cantidadElementos() + " (esperado: 6)");

        // Inicio y fin en la cima.
        Pila<String> cima = OperacionesPila.obtenerSegmento(crearPila(), 1, 1);
        System.out.println("\nSolo la cima (1, 1):          " + texto(cima));
        System.out.println("Esperado:                     A6");

        // Pila original vacía: cualquier rango válido numéricamente supera el tamaño.
        Pila<String> deVacia = OperacionesPila.obtenerSegmento(
                new Pila<String>(), 1, 1);
        System.out.println("Pila vacia (1, 1):            " + texto(deVacia));
        System.out.println("Esperado:                     Pila vacia");
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

    // Imprime los elementos desde el tope (vacía la pila)
    private static void imprimirPila(Pila<String> pila) {
        if (pila.estaVacia()) {
            System.out.println("Pila vacia");
            return;
        }

        while (!pila.estaVacia()) {
            System.out.println(pila.desapilar());
        }
    }

    // Devuelve el contenido desde el tope en una línea, sin alterar la pila
    private static String texto(Pila<String> pila) {
        if (pila.estaVacia()) {
            return "Pila vacia";
        }

        Pila<String> auxiliar = new Pila<>();
        StringBuilder resultado = new StringBuilder();

        while (!pila.estaVacia()) {
            String elemento = pila.desapilar();
            auxiliar.apilar(elemento);

            if (resultado.length() > 0) {
                resultado.append(" -> ");
            }
            resultado.append(elemento);
        }

        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }

        return resultado.toString();
    }
}
