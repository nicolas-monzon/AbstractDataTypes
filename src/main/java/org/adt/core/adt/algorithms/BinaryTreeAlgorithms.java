package org.adt.core.adt.algorithms;

import org.adt.core.adt.implementation.dynamic.BinaryTree;

public class BinaryTreeAlgorithms {

    public static void inOrder(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        inOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getValue());
        inOrder(binaryTree.getRight());
    }

    public static void preOrder(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        System.out.println(binaryTree.getValue());
        inOrder(binaryTree.getLeft());
        inOrder(binaryTree.getRight());
    }

    public static void postOrder(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return;
        }

        inOrder(binaryTree.getLeft());
        inOrder(binaryTree.getRight());
        System.out.println(binaryTree.getValue());
    }

    public static int weight(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + weight(binaryTree.getLeft()) + weight(binaryTree.getRight());
    }

    public static int height(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static int order(BinaryTree binaryTree, int element) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return -1;
        }
        if (binaryTree.getValue() == element) {
            int hasLeft = binaryTree.getLeft() == null ? 0 : 1;
            int hasRight = binaryTree.getRight() == null ? 0 : 1;
            return hasLeft + hasRight;
        }
        int candidate = order(binaryTree.getLeft(), element);
        if (candidate == -1) {
            return order(binaryTree.getRight(), element);
        }
        return candidate;
    }

    public static boolean skewed(BinaryTree binaryTree) {
        return leftSkewed(binaryTree) || rightSkewed(binaryTree);
    }

    public static boolean leftSkewed(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return binaryTree.getRight() == null && leftSkewed(binaryTree);
    }

    public static boolean rightSkewed(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return binaryTree.getLeft() == null && rightSkewed(binaryTree);
    }

    public static boolean degenerate(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        if (binaryTree.getLeft() != null) {
            if (binaryTree.getRight() != null) {
                return false;
            }
            return degenerate(binaryTree.getLeft());
        }

        if (binaryTree.getRight() != null) {
            if (binaryTree.getLeft() != null) {
                return false;
            }
            return degenerate(binaryTree.getRight());
        }

        return true;
    }

    public static boolean complete(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        return binaryTree.getLeft() != null &&
                binaryTree.getRight() != null &&
                complete(binaryTree.getLeft()) &&
                complete(binaryTree.getRight()) ||
                binaryTree.getLeft() == null && binaryTree.getRight() == null;
    }

    public static boolean perfect(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }

        if (!complete(binaryTree.getLeft()) || !complete(binaryTree.getRight())) {
            return false;
        }

        if (height(binaryTree.getLeft()) != height(binaryTree.getRight())) {
            return false;
        }

        return perfect(binaryTree.getLeft()) && perfect(binaryTree.getRight());
    }

    private static boolean existsLT(BinaryTree binaryTree, int value) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if (binaryTree.getValue() < value) {
            return true;
        }
        return existsLT(binaryTree.getLeft(), value) || existsLT(binaryTree.getRight(), value);
    }

    private static boolean existsGT(BinaryTree binaryTree, int value) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return false;
        }
        if (binaryTree.getValue() > value) {
            return true;
        }
        return existsGT(binaryTree.getLeft(), value) || existsGT(binaryTree.getRight(), value);
    }

    private static boolean isSBT(BinaryTree binaryTree) {
        if (binaryTree == null || binaryTree.isEmpty()) {
            return true;
        }
        return !existsGT(binaryTree.getLeft(), binaryTree.getValue()) &&
                !existsLT(binaryTree.getRight(), binaryTree.getValue()) &&
                isSBT(binaryTree.getLeft()) &&
                isSBT(binaryTree.getRight());
    }

}
