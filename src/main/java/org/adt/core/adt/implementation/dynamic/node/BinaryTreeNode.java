package org.adt.core.adt.implementation.dynamic.node;

import org.adt.core.adt.implementation.dynamic.BinaryTree;

public class BinaryTreeNode {

    private int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTreeNode(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
