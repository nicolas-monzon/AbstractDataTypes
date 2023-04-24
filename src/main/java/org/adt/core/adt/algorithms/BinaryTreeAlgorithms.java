package org.adt.core.adt.algorithms;

import org.adt.core.adt.implementation.dynamic.BinaryTree;

public class BinaryTreeAlgorithms {

    public static void inOrder(BinaryTree binaryTree) {
        if(binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        inOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getValue());
        inOrder(binaryTree.getRight());
    }

    public static void preOrder(BinaryTree binaryTree) {
        if(binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        System.out.println(binaryTree.getValue());
        inOrder(binaryTree.getLeft());
        inOrder(binaryTree.getRight());
    }

    public static void postOrder(BinaryTree binaryTree) {
        if(binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        inOrder(binaryTree.getLeft());
        inOrder(binaryTree.getRight());
        System.out.println(binaryTree.getValue());
    }

    public static int weight(BinaryTree binaryTree) {
        if(binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + weight(binaryTree.getLeft()) + weight(binaryTree.getRight());
    }

    public static int height(BinaryTree binaryTree) {
        if(binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static int order(BinaryTree binaryTree, int element) {
        if(binaryTree == null || binaryTree.isEmpty()) {
            return -1;
        }
        if(binaryTree.getValue() == element) {
            int hasLeft = binaryTree.getLeft() == null ? 0 : 1;
            int hasRight = binaryTree.getRight() == null ? 0 : 1;
            return hasLeft + hasRight;
        }
        int candidate = order(binaryTree.getLeft(), element);
        if(candidate == -1) {
            return order(binaryTree.getRight(), element);
        }
        return candidate;
    }

}
