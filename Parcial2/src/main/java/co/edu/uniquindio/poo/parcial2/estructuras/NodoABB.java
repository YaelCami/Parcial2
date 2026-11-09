package co.edu.uniquindio.poo.parcial2.estructuras;

public class NodoABB {
    int codigo;
    NodoABB izquierdo;
    NodoABB derecho;

    public NodoABB(int codigo) {
        this.codigo = codigo;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public NodoABB getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoABB izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoABB getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoABB derecho) {
        this.derecho = derecho;
    }
}
