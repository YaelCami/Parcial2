package co.edu.uniquindio.poo.parcial2.estructuras;

public class ArbolABB {
    private NodoABB raiz;

    public ArbolABB() {
        raiz = null;
    }

    public NodoABB getRaiz() {
        return raiz;
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

        // Los códigos son únicos: si ya existe, no se inserta.
        return actual;
    }

    /**
     * Función del enunciado: recibe el nodo raíz, un límite inferior y un
     * límite superior, y retorna cuántos equipos tienen códigos dentro del
     * rango (extremos incluidos). Es recursiva y aprovecha el orden del ABB.
     */
    public static int contarEquiposEnRango(
            NodoABB raiz, int limiteInferior, int limiteSuperior) {

        // Árbol vacío o límite inferior mayor que el superior.
        if (raiz == null || limiteInferior > limiteSuperior) {
            return 0;
        }

        // Si es menor que el límite inferior,
        // su subárbol izquierdo tampoco puede servir.
        if (raiz.codigo < limiteInferior) {
            return contarEquiposEnRango(
                    raiz.derecho, limiteInferior, limiteSuperior);
        }

        // Si es mayor que el límite superior,
        // su subárbol derecho tampoco puede servir.
        if (raiz.codigo > limiteSuperior) {
            return contarEquiposEnRango(
                    raiz.izquierdo, limiteInferior, limiteSuperior);
        }

        // El código está dentro del rango: se cuenta y se revisan ambos lados.
        return 1
                + contarEquiposEnRango(
                raiz.izquierdo, limiteInferior, limiteSuperior)
                + contarEquiposEnRango(
                raiz.derecho, limiteInferior, limiteSuperior);
    }

    // Atajo: usa la raíz de este árbol.
    public int contarEquiposEnRango(
            int limiteInferior, int limiteSuperior) {

        return contarEquiposEnRango(raiz, limiteInferior, limiteSuperior);
    }
}
