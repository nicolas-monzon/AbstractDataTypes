package org.adt.core.adt.definition;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface ISet {

    /**
     * Postcondicion: Agrega un valor al conjunto.
     * @param a valor a agregar.
     */
    void add(int a);

    /**
     * Postcondicion: Quita el elemento indicado si existe, de lo contrario no hace nada.
     * @param a valor a quitar.
     */
    void remove(int a);

    /**
     * @return <code>true</code> si es el conjunto vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el un elemento del conjunto.
     */
    int choose();

}
