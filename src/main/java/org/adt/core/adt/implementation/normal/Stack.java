package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IStack;

public class Stack implements IStack {

    private final int[] array;
    private int count;

    public Stack() {
        this.array = new int[10000];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacia");
            return;
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return -1;
        }
        return this.array[this.count - 1];
    }

}
