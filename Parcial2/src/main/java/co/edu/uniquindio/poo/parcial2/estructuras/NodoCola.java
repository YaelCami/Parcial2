package co.edu.uniquindio.poo.parcial2.estructuras;

public class NodoCola<T> {
    private T dato;
    private NodoCola<T> siguiente;

    public NodoCola(T dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato(){
        return dato;
    }

    public NodoCola<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente (NodoCola<T> siguiente){
        this.siguiente = siguiente;
    }
}

