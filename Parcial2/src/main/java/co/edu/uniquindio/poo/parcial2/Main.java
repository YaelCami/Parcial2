package co.edu.uniquindio.poo.parcial2;

import co.edu.uniquindio.poo.parcial2.logica.EjercicioCajas;
import co.edu.uniquindio.poo.parcial2.logica.PruebaArbolABB;
import co.edu.uniquindio.poo.parcial2.logica.PruebaGestorPaquetes;
import co.edu.uniquindio.poo.parcial2.logica.PruebaOperacionesPila;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   PRUEBAS INTEGRADAS - PARCIAL 2");
        System.out.println("========================================");

        ejecutarPrueba("1. PRUEBAS DE LA PILA",
                () -> PruebaOperacionesPila.main(args));

        ejecutarPrueba("2. PRUEBAS DE RETIRO DE CAJAS",
                () -> EjercicioCajas.main(args));

        ejecutarPrueba("3. PRUEBAS DE GESTION DE PAQUETES",
                () -> PruebaGestorPaquetes.main(args));

        ejecutarPrueba("4. PRUEBAS DEL ARBOL ABB",
                () -> PruebaArbolABB.main(args));

        System.out.println("\n========================================");
        System.out.println("   FIN DE LAS PRUEBAS INTEGRADAS");
        System.out.println("========================================");
    }

    private static void ejecutarPrueba(
            String titulo, Runnable prueba) {

        System.out.println("\n\n----------------------------------------");
        System.out.println(titulo);
        System.out.println("----------------------------------------");

        try {
            prueba.run();
            System.out.println("\nPrueba ejecutada.");
        } catch (Exception e) {
            System.out.println("Error durante la prueba: "
                    + e.getMessage());
            e.printStackTrace();
        }
    }

}

