package co.edu.uniquindio.poo.parcial2.estructuras;

public class ArbolABB {
    private NodoABB raiz;

    public ArbolABB() {
        raiz = null;
    }

    public void insertar(int codigo) {
        raiz = insertarRecursivo(raiz, codigo);
    }

    private NodoABB insertarRecursivo(
            NodoABB actual, int codigo) {

        if (actual == null) {
            return new NodoABB(codigo);
        }

        if (codigo < actual.codigo) {
            actual.izquierdo =
                    insertarRecursivo(actual.izquierdo, codigo);
        } else if (codigo > actual.codigo) {
            actual.derecho =
                    insertarRecursivo(actual.derecho, codigo);
        }

        // Los códigos son únicos.
        return actual;
    }

    public int contarEquiposEnRango(
            int limiteInferior, int limiteSuperior) {

        if (limiteInferior > limiteSuperior) {
            return 0;
        }

        return contarEquiposEnRangoRecursivo(
                raiz, limiteInferior, limiteSuperior);
    }

    private int contarEquiposEnRangoRecursivo(
            NodoABB nodo, int inferior, int superior) {

        if (nodo == null) {
            return 0;
        }

        // Si es menor que el límite inferior,
        // su subárbol izquierdo tampoco puede servir.
        if (nodo.codigo < inferior) {
            return contarEquiposEnRangoRecursivo(
                    nodo.derecho, inferior, superior);
        }

        // Si es mayor que el límite superior,
        // su subárbol derecho tampoco puede servir.
        if (nodo.codigo > superior) {
            return contarEquiposEnRangoRecursivo(
                    nodo.izquierdo, inferior, superior);
        }

        // El código está dentro del rango.
        return 1
                + contarEquiposEnRangoRecursivo(
                nodo.izquierdo, inferior, superior)
                + contarEquiposEnRangoRecursivo(
                nodo.derecho, inferior, superior);
    }
}
