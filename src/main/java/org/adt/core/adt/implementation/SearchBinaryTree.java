package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.ISearchBinaryTree;
import org.adt.core.adt.implementation.dynamic.BinaryTree;

public class SearchBinaryTree implements ISearchBinaryTree {

    private final BinaryTree binaryTree;

    public SearchBinaryTree() {
        this.binaryTree = new BinaryTree();
    }

    private SearchBinaryTree(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public int getValue() {
        return this.binaryTree.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.binaryTree.isEmpty();
    }

    @Override
    public void add(int element) {
        if(binaryTree.isEmpty()) {
            binaryTree.create(element);
            return;
        }
        if(element > binaryTree.getValue()) {
            if(binaryTree.getRight() == null) {
                binaryTree.addRight(element);
                return;
            }
            SearchBinaryTree searchBinaryTree = new SearchBinaryTree(binaryTree.getRight());
            searchBinaryTree.add(element);
            return;
        }

        if(binaryTree.getLeft() == null) {
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
        return new SearchBinaryTree(this.binaryTree.getLeft());
    }

    @Override
    public ISearchBinaryTree getRight() {
        return new SearchBinaryTree(this.binaryTree.getRight());
    }

}
