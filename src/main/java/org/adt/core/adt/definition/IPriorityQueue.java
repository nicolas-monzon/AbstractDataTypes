package org.adt.core.adt.definition;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IPriorityQueue {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor, respecto a su prioridad.
     * @param a valor a acolar.
     * @param priority prioridad del valor a agregar.
     */
    void add(int a, int priority);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    int getFirst();

    /**
     * @return Devuelve la prioridad del primero.
     */
    int getPriority();

}
