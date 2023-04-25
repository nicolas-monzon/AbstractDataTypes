package org.adt.core.adt.implementation.dynamic;

public class SearchBinaryTree {

    private BinaryTree binaryTree;

    public SearchBinaryTree() {
        this.binaryTree = new BinaryTree();
    }

    private SearchBinaryTree(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

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

    public void removeLeft() {
        this.binaryTree.removeLeft();
    }

    // ...

}
