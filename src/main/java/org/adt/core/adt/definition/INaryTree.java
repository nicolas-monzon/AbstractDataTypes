package org.adt.core.adt.definition;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface INaryTree {

    /**
     * Convierte un arbol vacio en un arbol con un unico nodo que es su raiz.
     * Si el arbol ya tiene raiz, aunque tenga nodos, este metodo reemplaza el arbol entero
     * por un nuevo arbol con solo raiz.
     *
     * @param value, valor que tendra la raiz del arbol.
     */
    void create(int value);

    /**
     * Precondicion: El arbol no esta vacio.
     *
     * @return valor de la raiz del arbol.
     */
    Integer getValue();

    /**
     * @return <code>true</code> solo cuando el arbol esta vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * Precondicion: El arbol no esta vacio.
     * Crea un arbol con solo raiz que reemplaza su hijo en la posicion indicada.
     *
     * @param value, valor del hijo
     * @param index, posicion del hijo
     */
    void add(int value, int index);

    /**
     * Precondicion: El arbol no esta vacio.
     * Elimina el hijo en la posicion indicada. En caso de no tener, no hace nada.
     * @param index, posicion del hijo
     */
    void remove(int index);

    /**
     * @param index, posicion del hijo
     * @return hijo en la posicion indicada, o <code>null</code> en caso de no tener.
     */
    IBinaryTree get(int index);
    
}
