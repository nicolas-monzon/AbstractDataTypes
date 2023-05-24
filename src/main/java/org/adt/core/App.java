package org.adt.core;

import org.adt.core.adt.algorithms.BinaryTreeAlgorithms;
import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.implementation.dynamic.BinaryTree;

public class App {

    public static void main(String[] args) {

        IBinaryTree binaryTree = new BinaryTree();

        binaryTree.create(10);
        binaryTree.addLeft(18);
        binaryTree.getLeft().addLeft(-5);
        binaryTree.getLeft().getLeft().addLeft(-2);
        binaryTree.getLeft().addRight(80);
        binaryTree.addRight(19);
        binaryTree.getRight().addRight(16);
        binaryTree.getRight().addLeft(27);
        binaryTree.getRight().getLeft().addLeft(21);
        binaryTree.getRight().getLeft().addRight(99);

        System.out.println(BinaryTreeAlgorithms.latex(binaryTree));

        System.out.println("Welcome!");
    }

}
