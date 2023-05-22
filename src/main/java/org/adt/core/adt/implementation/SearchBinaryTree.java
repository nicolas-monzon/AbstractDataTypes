package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.definition.ISearchBinaryTree;
import org.adt.core.adt.implementation.dynamic.BinaryTree;

public class SearchBinaryTree implements ISearchBinaryTree {

    private final IBinaryTree binaryTree;

    public SearchBinaryTree() {
        this.binaryTree = new BinaryTree();
    }

    private SearchBinaryTree(IBinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public int getValue() {
        if (this.isEmpty()) {
            System.out.println("SearchBinaryTree is not initialized");
            return -1;
        }
        return this.binaryTree.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.binaryTree == null || this.binaryTree.isEmpty();
    }

    @Override
    public void add(int element) {
        if (binaryTree.isEmpty()) {
            binaryTree.create(element);
            return;
        }
        if (element > binaryTree.getValue()) {
            if (binaryTree.getRight() == null) {
                binaryTree.addRight(element);
                return;
            }
            SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTree.getRight());
            searchBinaryTree.add(element);
            return;
        }

        if (binaryTree.getLeft() == null) {
            binaryTree.addLeft(element);
            return;
        }
        SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTree.getLeft());
        searchBinaryTree.add(element);
    }

    @Override
    public void removeLeft() {
        this.binaryTree.removeLeft();
    }

    @Override
    public void removeRight() {
        this.binaryTree.removeRight();
    }

    @Override
    public ISearchBinaryTree getLeft() {
        try {
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTree.getLeft());
            if (candidate.isEmpty()) {
                return null;
            }
            return candidate;
        } catch (RuntimeException e) {
            throw new RuntimeException("The search binary tree is empty");
        }
    }

    @Override
    public ISearchBinaryTree getRight() {
        try {
            SearchBinaryTree candidate = new SearchBinaryTree(this.binaryTree.getRight());
            if (candidate.isEmpty()) {
                return null;
            }
            return candidate;
        } catch (RuntimeException e) {
            throw new RuntimeException("The search binary tree is empty");
        }
    }

}
