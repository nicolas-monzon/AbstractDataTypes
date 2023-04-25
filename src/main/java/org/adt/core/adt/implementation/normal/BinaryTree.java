package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IBinaryTree;

public class BinaryTree implements IBinaryTree {

    private Integer[] array;

    public BinaryTree() {
        this.array = new Integer[100000];
    }

    @Override
    public void create(int value) {
        this.array[0] = value;
        for(int i = 1; i < this.array.length; i++) {
            this.array[i] = null;
        }
    }

    @Override
    public int getValue() {
        return this.array[0];
    }

    @Override
    public boolean isEmpty() {
        return this.array[0] == null;
    }

    @Override
    public void addLeft(int value) {
        this.array[1] = value;
        clean(3);
        clean(4);
    }

    @Override
    public void addRight(int value) {
        this.array[2] = value;
        clean(5);
        clean(6);
    }

    @Override
    public void removeLeft() {
        clean(1);
    }

    @Override
    public void removeRight() {
        clean(2);
    }

    @Override
    public BinaryTree getLeft() {
        return null;
    }

    @Override
    public BinaryTree getRight() {
        return null;
    }

    private void clean(int index) {
        if(index >= this.array.length) {
            return;
        }
        this.array[index] = null;
        clean(index*2 + 1);
        clean(index*2 + 2);
    }
}
