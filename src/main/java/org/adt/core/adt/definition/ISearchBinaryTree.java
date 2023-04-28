package org.adt.core.adt.definition;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ISearchBinaryTree {

    /**
     * Precondicion: El arbol no esta vacio.
     * @return valor de la raiz del arbol.
     */
    int getValue();

    /**
     * @return <code>true</code> solo cuando el arbol esta vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * Si el arbol es vacio, crea su raiz con el elemento pasado como parametro.
     * Siempre crea un arbol, siguiendo el siguiente algoritmo: Si el elemento a agregar es mayor, trata de agregarlo
     * a la derecha, si es menor a la izquierda, y si no puede aplica recursividad sobre el nodo actual.
     * @param value, valor a agregar.
     */
    void add(int value);

    /**
     * Precondicion: El arbol no esta vacio.
     * Elimina el hijo izquierdo. En caso de no tener, no hace nada.
     */
    void removeLeft();

    /**
     * Precondicion: El arbol no esta vacio.
     * Elimina el hijo derecho. En caso de no tener, no hace nada.
     */
    void removeRight();

    /**
     * @return hijo izquierdo, o <code>null</code> en caso de no tener.
     */
    ISearchBinaryTree getLeft();

    /**
     * @return hijo derecho, o <code>null</code> en caso de no tener.
     */
    ISearchBinaryTree getRight();
}
