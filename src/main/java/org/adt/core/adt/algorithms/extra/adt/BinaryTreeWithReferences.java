package org.adt.core.adt.algorithms.extra.adt;

import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.implementation.dynamic.node.BinaryTreeNode;

public class BinaryTreeWithReferences implements IBinaryTree {

    private BinaryTreeNode root;

    @Override
    public void create(int value) {
        this.root = new BinaryTreeNode(value, null, null);
    }

    @Override
    public Integer getValue() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void addLeft(int value) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        IBinaryTree binaryTree = new BinaryTreeWithReferences();
        binaryTree.create(value);
        this.root.setRight(binaryTree);
    }

    public void addLeft(IBinaryTree value) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setLeft(value);
    }

    @Override
    public void addRight(int value) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        IBinaryTree binaryTree = new BinaryTreeWithReferences();
        binaryTree.create(value);
        this.root.setRight(binaryTree);
    }

    public void addRight(IBinaryTree value) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setRight(value);
    }

    @Override
    public void removeLeft() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setLeft(null);
    }

    @Override
    public void removeRight() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setRight(null);
    }

    @Override
    public IBinaryTree getLeft() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    @Override
    public IBinaryTree getRight() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }
}
