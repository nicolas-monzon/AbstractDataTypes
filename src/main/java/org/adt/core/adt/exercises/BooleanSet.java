package org.adt.core.adt.exercises;

import org.adt.core.adt.definition.ISet;

import java.util.Random;

public class BooleanSet implements ISet {

    private final BooleanStack stack;
    int min;
    int max;
    private int count;

    public BooleanSet(int min, int max) {
        this.stack = new BooleanStack();

        // Considero el tope como la posicion 0
        for (int i = 0; i < max - min + 1; i++) {
            this.stack.add(false);
        }

        this.min = min;
        this.max = max;
        this.count = 0;
    }

    @Override
    public void add(int a) {
        int index = a - min;
        this.set(index, true);
        this.count++;
    }

    private void set(int index, boolean p) {
        BooleanStack aux = new BooleanStack();
        for (int i = 0; i < index; i++) {
            aux.add(this.stack.getTop());
            this.stack.remove();
        }

        // El tope es el valor asociado a index
        this.stack.remove();
        this.stack.add(p);

        // Recompongo la pila
        while (!aux.isEmpty()) {
            this.stack.add(aux.getTop());
            aux.remove();
        }
    }

    @Override
    public void remove(int a) {
        int index = a - min;
        this.set(index, false);
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.max - this.min + 1);
        if (this.get(randomIndex)) {
            return randomIndex + this.min;
        }
        return this.choose();
    }

    private boolean get(int index) {
        BooleanStack aux = new BooleanStack();
        for (int i = 0; i < index; i++) {
            aux.add(this.stack.getTop());
            this.stack.remove();
        }

        // El tope es el valor asociado a index
        boolean result = this.stack.getTop();

        // Recompongo la pila
        while (!aux.isEmpty()) {
            this.stack.add(aux.getTop());
            aux.remove();
        }

        return result;
    }

}