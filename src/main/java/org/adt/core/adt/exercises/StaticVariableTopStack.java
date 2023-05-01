package org.adt.core.adt.exercises;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.definition.IVariableTopStack;
import org.adt.core.adt.implementation.normal.Stack;

public class StaticVariableTopStack implements IVariableTopStack {

    private final int[] array;
    private int count;
    private final int topLen;

    public StaticVariableTopStack(int topLen) {
        this.array = new int[10000];
        this.count = 0;
        this.topLen = topLen;
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
    public IStack getTop() {
        if (count == 0) {
            throw new RuntimeException("Error, no se puede obtener el tope de una pila vacia");
        }
        if (count < topLen) {
            throw new RuntimeException("Error, no hay suficientes elementos");
        }
        IStack stack = new Stack();

        for (int i = this.count - 1; i > this.count - 1 - topLen; i--) {
            stack.add(this.array[i]);
        }

        return stack;
    }

}
