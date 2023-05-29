package org.adt.core.adt.exercises;

public class BooleanStack {

    private final boolean[] array;
    private int count;

    public BooleanStack() {
        this.array = new boolean[10000];
        this.count = 0;
    }

    public void add(boolean p) {
        this.array[this.count] = p;
        this.count++;
    }

    public void remove() {
        if (this.count == 0) {
            throw new RuntimeException("Empty stack");
        }
        this.count--;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean getTop() {
        if (this.count == 0) {
            throw new RuntimeException("Empty stack");
        }
        return this.array[this.count - 1];
    }
}
