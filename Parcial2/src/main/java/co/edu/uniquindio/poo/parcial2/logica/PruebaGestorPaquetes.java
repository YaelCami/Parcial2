package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Cola;
import co.edu.uniquindio.poo.parcial2.modelo.Paquete;
import co.edu.uniquindio.poo.parcial2.modelo.TipoEntrega;

public class PruebaGestorPaquetes {
    public static void main(String[] args){
        GestorPaquetes gestor = new GestorPaquetes();

        Cola<Paquete> pendientes = new Cola<>();
        pendientes.encolar(new Paquete("P1", TipoEntrega.NORMAL, 4));
        pendientes.encolar(new Paquete("P2", TipoEntrega.URGENTE, 7));
        pendientes.encolar(new Paquete("P3", TipoEntrega.NORMAL, 3));
        pendientes.encolar(new Paquete("P4", TipoEntrega.URGENTE, 5));
        pendientes.encolar(new Paquete("P5", TipoEntrega.NORMAL, 6));
        pendientes.encolar(new Paquete("P6", TipoEntrega.URGENTE, 4));
        pendientes.encolar(new Paquete("P7", TipoEntrega.NORMAL, 2));

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
    }
}
