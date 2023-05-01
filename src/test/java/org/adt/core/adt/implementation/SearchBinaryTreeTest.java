package org.adt.core.adt.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchBinaryTreeTest {

    private SearchBinaryTree searchBinaryTree;

    @BeforeEach
    public void beforeEach() {
        this.searchBinaryTree = new SearchBinaryTree();
    }

    @Test
    @DisplayName("Should add elements in order successfully")
    public void add() {
        assertTrue(this.searchBinaryTree.isEmpty());
        this.searchBinaryTree.add(1);
        assertFalse(this.searchBinaryTree.isEmpty());
        assertEquals(1, this.searchBinaryTree.getValue());

        assertNull(this.searchBinaryTree.getRight());
        assertNull(this.searchBinaryTree.getLeft());
        this.searchBinaryTree.add(0);
        assertNull(this.searchBinaryTree.getRight());
        assertNotNull(this.searchBinaryTree.getLeft());

        this.searchBinaryTree.removeLeft();
        this.searchBinaryTree.add(2);
        assertNotNull(this.searchBinaryTree.getRight());
        assertNull(this.searchBinaryTree.getLeft());
    }

    @Test
    @DisplayName("Should get root value successfully")
    public void getValue() {
        assertEquals(-1, this.searchBinaryTree.getValue());
        this.searchBinaryTree.add(1);
        assertEquals(1, this.searchBinaryTree.getValue());
    }

    @Test
    @DisplayName("Should remove left subtree successfully")
    public void removeLeft() {
        this.searchBinaryTree.add(1);
        this.searchBinaryTree.add(0);
        this.searchBinaryTree.removeLeft();
        assertNull(this.searchBinaryTree.getLeft());
    }

    @Test
    @DisplayName("Should remove right subtree successfully")
    public void removeRight() {
        this.searchBinaryTree.add(1);
        this.searchBinaryTree.add(2);
        this.searchBinaryTree.removeRight();
        assertNull(this.searchBinaryTree.getRight());
    }

    @Test
    @DisplayName("Should get right subtree successfully")
    public void getLeft() {
        assertThrows(RuntimeException.class, () -> this.searchBinaryTree.getLeft());
        this.searchBinaryTree.add(1);
        assertNull(this.searchBinaryTree.getLeft());
        this.searchBinaryTree.add(0);
        assertNotNull(this.searchBinaryTree.getLeft());
        assertEquals(0, this.searchBinaryTree.getLeft().getValue());
    }

    @Test
    @DisplayName("Should get right subtree successfully")
    public void getRight() {
        assertThrows(RuntimeException.class, () -> this.searchBinaryTree.getRight());
        this.searchBinaryTree.add(1);
        assertNull(this.searchBinaryTree.getRight());
        this.searchBinaryTree.add(2);
        assertNotNull(this.searchBinaryTree.getRight());
        assertEquals(2, this.searchBinaryTree.getRight().getValue());
    }

    @Test
    @DisplayName("Should check if exists elements in the tree")
    public void isEmpty() {
        assertTrue(this.searchBinaryTree.isEmpty());
        this.searchBinaryTree.add(1);
        assertFalse(this.searchBinaryTree.isEmpty());
    }

}
