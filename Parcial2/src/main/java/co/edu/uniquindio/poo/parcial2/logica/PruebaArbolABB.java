package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.ArbolABB;

public class PruebaArbolABB {
    public static void main(String[] args) {
        ArbolABB arbol = new ArbolABB();

        int[] codigos = {
                41, 20, 52, 16, 6, 13, 12,
                60, 22, 47, 50, 43, 44
        };

        for (int codigo : codigos) {
            arbol.insertar(codigo);
        }

        System.out.println("Prueba 1 (20, 50): "
                + arbol.contarEquiposEnRango(20, 50));

        System.out.println("Prueba 2 (43, 47): "
                + arbol.contarEquiposEnRango(43, 47));

        System.out.println("Prueba 3 (70, 90): "
                + arbol.contarEquiposEnRango(70, 90));

        System.out.println("Prueba 4 (50, 20): "
                + arbol.contarEquiposEnRango(50, 20));
    }
}
