package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IBinaryTree;

public class BinaryTree implements IBinaryTree {

    private final Integer[] array;
    private final int rootIndex;
    private final int MAX_CAPACITY = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 - 1;

    public BinaryTree() {
        this.array = new Integer[MAX_CAPACITY];
        this.rootIndex = 0;
    }

    private BinaryTree(Integer[] array, int rootIndex) {
        this.array = array;
        this.rootIndex = rootIndex;
    }

    @Override
    public void create(int value) {
        this.array[rootIndex] = value;
        for (int i = 1; i < this.array.length; i++) {
            this.array[i] = null;
        }
    }

    @Override
    public Integer getValue() {
        return this.array[rootIndex];
    }

    @Override
    public boolean isEmpty() {
        return this.array[rootIndex] == null;
    }

    @Override
    public void addLeft(int value) {
        if (rootIndex * 2 + 1 > MAX_CAPACITY) {
            throw new RuntimeException("Excedida la altura del arbol");
        }
        this.array[rootIndex * 2 + 1] = value;
        clean((rootIndex * 2 + 1) * 2 + 1);
        clean((rootIndex * 2 + 1) * 2 + 2);
    }

    @Override
    public void addRight(int value) {
        if (rootIndex * 2 + 2 > MAX_CAPACITY) {
            throw new RuntimeException("Excedida la altura del arbol");
        }
        this.array[rootIndex * 2 + 2] = value;
        clean((rootIndex * 2 + 2) * 2 + 1);
        clean((rootIndex * 2 + 2) * 2 + 2);
    }

    @Override
    public void removeLeft() {
        clean(rootIndex * 2 + 1);
    }

    @Override
    public void removeRight() {
        clean(rootIndex * 2 + 2);
    }

    @Override
    public BinaryTree getLeft() {
        if (rootIndex * 2 + 1 > MAX_CAPACITY) {
            return null;
        }
        BinaryTree candidate = new BinaryTree(this.array, rootIndex * 2 + 1);
        if (candidate.isEmpty()) {
            return null;
        }
        return candidate;
    }

    @Override
    public BinaryTree getRight() {
        if (rootIndex * 2 + 2 > MAX_CAPACITY) {
            return null;
        }
        BinaryTree candidate = new BinaryTree(this.array, rootIndex * 2 + 2);
        if (candidate.isEmpty()) {
            return null;
        }
        return candidate;
    }

    private void clean(int index) {
        if (index >= this.array.length) {
            return;
        }
        this.array[index] = null;
        clean(index * 2 + 1);
        clean(index * 2 + 2);
    }
}
