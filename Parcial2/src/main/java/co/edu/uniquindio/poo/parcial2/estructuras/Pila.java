package co.edu.uniquindio.poo.parcial2.estructuras;

import java.util.NoSuchElementException;

public class Pila<T> {
    private Nodo<T> tope;
    private int cantidad;

    public Pila() {
        tope = null;
        cantidad = 0;
    }

    public void apilar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        nuevo.siguiente = tope;
        tope = nuevo;
        cantidad++;
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new NoSuchElementException(
                    "La pila está vacía"
            );
        }

        T dato = tope.dato;
        tope = tope.siguiente;
        cantidad--;

        return dato;
    }

    public T cima() {
        if (estaVacia()) {
            throw new NoSuchElementException(
                    "La pila está vacía"
            );
        }

        return tope.dato;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int cantidadElementos() {
        return cantidad;
    }

}
