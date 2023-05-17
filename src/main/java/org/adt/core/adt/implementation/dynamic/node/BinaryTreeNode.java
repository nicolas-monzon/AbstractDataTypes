package org.adt.core.adt.implementation.dynamic.node;

import org.adt.core.adt.definition.IBinaryTree;

public class BinaryTreeNode {

    private int value;
    private IBinaryTree left;
    private IBinaryTree right;

    public BinaryTreeNode(int value, IBinaryTree left, IBinaryTree right) {
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

    public IBinaryTree getLeft() {
        return left;
    }

    public void setLeft(IBinaryTree left) {
        this.left = left;
    }

    public IBinaryTree getRight() {
        return right;
    }

    public void setRight(IBinaryTree right) {
        this.right = right;
    }
}
