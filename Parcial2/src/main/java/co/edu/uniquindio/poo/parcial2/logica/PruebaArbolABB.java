package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.ArbolABB;

public class PruebaArbolABB {
    public static void main(String[] args) {
        ArbolABB arbol = new ArbolABB();

        // Secuencia exacta del enunciado (punto 4b). El 60 aparece dos veces,
        // pero como los códigos son únicos, ArbolABB ignora la segunda inserción.
        int[] codigos = {
                41, 20, 52, 16, 6, 13, 12,
                60, 22, 47, 50, 60, 43, 44
        };

        for (int codigo : codigos) {
            arbol.insertar(codigo);
        }

        System.out.println("--- Pruebas con la raiz (firma del enunciado) ---");
        verificar("Rango (20, 50)", 7,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 20, 50));
        verificar("Rango (43, 47)", 3,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 43, 47));
        verificar("Rango (70, 90), sin codigos", 0,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 70, 90));
        verificar("Rango (50, 20), inferior > superior", 0,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 50, 20));

        System.out.println("\n--- Casos adicionales ---");
        verificar("Arbol vacio (1, 10)", 0,
                ArbolABB.contarEquiposEnRango(new ArbolABB().getRaiz(), 1, 10));
        verificar("Limites iguales y existe (41, 41)", 1,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 41, 41));
        verificar("Limites iguales y no existe (45, 45)", 0,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 45, 45));
        verificar("Rango sin codigos entre 44 y 47 (45, 46)", 0,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 45, 46));
        verificar("Extremos incluidos (6, 12)", 2,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 6, 12));
        verificar("Todo el arbol (0, 100), 13 codigos unicos", 13,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 0, 100));
        verificar("El 60 repetido cuenta una sola vez (60, 60)", 1,
                ArbolABB.contarEquiposEnRango(arbol.getRaiz(), 60, 60));

        System.out.println("\n--- Atajo con la raiz del propio arbol ---");
        verificar("arbol.contarEquiposEnRango(20, 50)", 7,
                arbol.contarEquiposEnRango(20, 50));
    }

    private static void verificar(String caso, int esperado, int obtenido) {
        String estado = esperado == obtenido ? "OK" : "FALLO";
        System.out.println(caso + ": esperado = " + esperado
                + ", obtenido = " + obtenido + " -> " + estado);
    }
}
