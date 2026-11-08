package co.edu.uniquindio.poo.parcial2.logica;

import co.edu.uniquindio.poo.parcial2.estructuras.Cola;
import co.edu.uniquindio.poo.parcial2.modelo.Paquete;
import co.edu.uniquindio.poo.parcial2.modelo.TipoEntrega;

public class GestorPaquetes {
    private int capacidadRestante;

    public Cola<Paquete> seleccionarPaquetes(Cola<Paquete> pendientes, int capacidad) {
        Cola<Paquete> seleccionados = new Cola<>();
        capacidadRestante = capacidad;

        if (capacidad <= 0) {
            return seleccionados;
        }

        capacidadRestante = procesar(pendientes, seleccionados, TipoEntrega.URGENTE, capacidadRestante, pendientes.getTamanio());
        capacidadRestante = procesar(pendientes, seleccionados, TipoEntrega.NORMAL, capacidadRestante, pendientes.getTamanio());

        return seleccionados;
    }



    public int procesar (Cola<Paquete> pendientes, Cola<Paquete> seleccionados, TipoEntrega tipo, int capacidad, int n) {
        if (n == 0) {
            return capacidad;
        }

        Paquete p = pendientes.desencolar();

        if (p.getTipo() == tipo) {
            if (p.getPeso () <= capacidad) {
                seleccionados.encolar(p);
                capacidad = capacidad - p.getPeso();
                System.out.println(p + " -> Seleccionado");
            } else {
                pendientes.encolar(p);
                System.out.println(p + " -> No cabe, asi que queda PENDIENTE");
            }
        } else {
            pendientes.encolar(p);
        }
        return procesar(pendientes, seleccionados, tipo, capacidad, n - 1);
    }

    public void mostrar(Cola<Paquete> cola) {
        mostrar(cola, cola.getTamanio());
    }

    public void mostrar(Cola<Paquete> cola, int n) {
        if (n == 0) {
            return;
        }
        Paquete p = cola.desencolar();
        System.out.println(p);
        cola.encolar(p);
        mostrar(cola, n-1);
    }

    public int getCapacidadRestante() {
        return capacidadRestante;
    }
}
