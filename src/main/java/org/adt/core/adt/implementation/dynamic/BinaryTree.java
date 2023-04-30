package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.implementation.dynamic.node.BinaryTreeNode;

public class BinaryTree implements IBinaryTree {
    
    private BinaryTreeNode root;

    @Override
    public void create(int value) {
        this.root = new BinaryTreeNode(value, null, null);
    }

    @Override
    public Integer getValue() {
        if(this.root == null) {
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
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(value);
        this.root.setLeft(binaryTree);
    }

    @Override
    public void addRight(int value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(value);
        this.root.setRight(binaryTree);
    }

    @Override
    public void removeLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setLeft(null);
    }

    @Override
    public void removeRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setRight(null);
    }

    @Override
    public BinaryTree getLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    @Override
    public BinaryTree getRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }
}
