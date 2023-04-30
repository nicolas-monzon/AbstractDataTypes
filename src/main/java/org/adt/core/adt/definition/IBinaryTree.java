package org.adt.core.adt.definition;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IBinaryTree {

    /**
     * Convierte un arbol vacio en un arbol con un unico nodo que es su raiz.
     * Si el arbol ya tiene raiz, aunque tenga nodos, este metodo reemplaza el arbol entero
     * por un nuevo arbol con solo raiz.
     * @param value, valor que tendra la raiz del arbol.
     */
    void create(int value);

    /**
     * Precondicion: El arbol no esta vacio.
     * @return valor de la raiz del arbol.
     */
    Integer getValue();

    /**
     * @return <code>true</code> solo cuando el arbol esta vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * Precondicion: El arbol no esta vacio.
     * Crea un arbol con solo raiz que reemplaza su hijo izquierdo actual.
     * @param value, valor de la raiz del hijo izquierdo.
     */
    void addLeft(int value);

    /**
     * Precondicion: El arbol no esta vacio.
     * Crea un arbol con solo raiz que reemplaza su hijo derecho actual.
     * @param value, valor de la raiz del hijo derecho.
     */
    void addRight(int value);

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
    IBinaryTree getLeft();

    /**
     * @return hijo derecho, o <code>null</code> en caso de no tener.
     */
    IBinaryTree getRight();
}
