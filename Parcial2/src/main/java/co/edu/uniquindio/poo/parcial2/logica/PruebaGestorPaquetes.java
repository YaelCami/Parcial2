package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Cola;
import co.edu.uniquindio.poo.parcial2.modelo.Paquete;
import co.edu.uniquindio.poo.parcial2.modelo.TipoEntrega;

public class PruebaGestorPaquetes {
    public static void main(String[] args){
        GestorPaquetes gestor = new GestorPaquetes();

        Cola<Paquete> pendientes = crearColaEnunciado();

        System.out.println("Gestion de Paquetes");
        System.out.println("Cola inicial, desde el inicio hasta el final:");
        gestor.mostrar(pendientes);

        System.out.println("\nEvaluacion de paquetes, teniendo una capacidad maxima de 14 kg:");
        Cola<Paquete> seleccionados = gestor.seleccionarPaquetes(pendientes, 14);

        System.out.println("\nCola retornada:");
        gestor.mostrar(seleccionados);

        System.out.println("\nPaquete que quedaron pendientes despues de la seleccion:");
        gestor.mostrar(pendientes);

        System.out.println("\nCapacidad disponible: " + gestor.getCapacidadRestante() + " kg");

        casosAdicionales();
    }

    // Los siete paquetes del enunciado, en orden de llegada.
    private static Cola<Paquete> crearColaEnunciado() {
        Cola<Paquete> cola = new Cola<>();
        cola.encolar(new Paquete("P1", TipoEntrega.NORMAL, 4));
        cola.encolar(new Paquete("P2", TipoEntrega.URGENTE, 7));
        cola.encolar(new Paquete("P3", TipoEntrega.NORMAL, 3));
        cola.encolar(new Paquete("P4", TipoEntrega.URGENTE, 5));
        cola.encolar(new Paquete("P5", TipoEntrega.NORMAL, 6));
        cola.encolar(new Paquete("P6", TipoEntrega.URGENTE, 4));
        cola.encolar(new Paquete("P7", TipoEntrega.NORMAL, 2));
        return cola;
    }

    private static void casosAdicionales() {
        System.out.println("\n\n--- CASOS ADICIONALES ---");

        // Capacidad igual a cero: cola vacía y pendientes sin cambios.
        ejecutarCaso("Capacidad 0 kg",
                crearColaEnunciado(), 0,
                "cola retornada vacia; pendientes P1 P2 P3 P4 P5 P6 P7 sin cambios");

        // Capacidad negativa: igual que cero.
        ejecutarCaso("Capacidad -5 kg",
                crearColaEnunciado(), -5,
                "cola retornada vacia; pendientes P1 P2 P3 P4 P5 P6 P7 sin cambios");

        // Un paquete cabe justo: peso igual a la capacidad restante.
        ejecutarCaso("Capacidad 7 kg (P2 pesa justo 7)",
                crearColaEnunciado(), 7,
                "retornada: P2; pendientes: P1 P3 P4 P5 P6 P7; capacidad restante 0");

        // Nada cabe.
        ejecutarCaso("Capacidad 1 kg (nada cabe)",
                crearColaEnunciado(), 1,
                "cola retornada vacia; pendientes P1 P2 P3 P4 P5 P6 P7 en su orden; capacidad restante 1");

        // Todo cabe: primero urgentes (P2 P4 P6) y luego normales (P1 P3 P5 P7).
        ejecutarCaso("Capacidad 100 kg (todo cabe)",
                crearColaEnunciado(), 100,
                "retornada: P2 P4 P6 P1 P3 P5 P7; pendientes vacia; capacidad restante 69");

        // Sin paquetes urgentes: solo se procesan los normales.
        Cola<Paquete> soloNormales = new Cola<>();
        soloNormales.encolar(new Paquete("N1", TipoEntrega.NORMAL, 5));
        soloNormales.encolar(new Paquete("N2", TipoEntrega.NORMAL, 9));
        soloNormales.encolar(new Paquete("N3", TipoEntrega.NORMAL, 4));
        ejecutarCaso("Solo paquetes normales, capacidad 10 kg",
                soloNormales, 10,
                "retornada: N1 N3; pendientes: N2; capacidad restante 1");

        // Cola de pendientes vacía.
        ejecutarCaso("Cola de pendientes vacia, capacidad 10 kg",
                new Cola<Paquete>(), 10,
                "cola retornada vacia; pendientes vacia; capacidad restante 10");
    }

    private static void ejecutarCaso(String titulo, Cola<Paquete> pendientes,
                                     int capacidad, String esperado) {
        GestorPaquetes gestor = new GestorPaquetes();

        System.out.println("\n== " + titulo + " ==");
        System.out.println("Esperado: " + esperado);

        Cola<Paquete> seleccionados = gestor.seleccionarPaquetes(pendientes, capacidad);

        mostrarCola(gestor, "Cola retornada:", seleccionados);
        mostrarCola(gestor, "Pendientes despues:", pendientes);
        System.out.println("Capacidad disponible: " + gestor.getCapacidadRestante() + " kg");
    }

    private static void mostrarCola(GestorPaquetes gestor, String titulo,
                                    Cola<Paquete> cola) {
        System.out.println(titulo);
        if (cola.estaVacia()) {
            System.out.println("(vacia)");
        } else {
            gestor.mostrar(cola);
        }
    }
}
