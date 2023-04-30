package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.IBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseBinaryTreeTest {

    private IBinaryTree binaryTree;

    public abstract IBinaryTree getBinaryTree();

    @BeforeEach
    public void beforeEach() {
        this.binaryTree = this.getBinaryTree();
    }

    @Test
    @DisplayName("Should create a tree only with root with the correct value")
    public void create() {
        assertTrue(this.binaryTree.isEmpty());
        assertNull(this.binaryTree.getLeft());
        assertNull(this.binaryTree.getRight());
        this.binaryTree.create(1);
        assertFalse(binaryTree.isEmpty());
        assertEquals(1, this.binaryTree.getValue());
        assertNull(this.binaryTree.getLeft());
        assertNull(this.binaryTree.getRight());
    }

    @Test
    @DisplayName("Should get root value of the tree")
    public void getValue() {
        assertNull(this.binaryTree.getValue());
        this.binaryTree.create(1);
        assertNotNull(this.binaryTree.getValue());
        assertEquals(1, this.binaryTree.getValue());
    }

    @Test
    @DisplayName("Should check if root not exists successfully")
    public void isEmpty() {
        assertTrue(this.binaryTree.isEmpty());
        this.binaryTree.create(1);
        assertFalse(this.binaryTree.isEmpty());
    }

    @Test
    @DisplayName("Should check if element was added to left side successfully")
    public void addLeft() {
        this.binaryTree.create(1);
        assertNull(this.binaryTree.getLeft());
        this.binaryTree.addLeft(2);
        assertNotNull(this.binaryTree.getLeft());
        assertEquals(2, this.binaryTree.getLeft().getValue());
    }

    @Test
    @DisplayName("Should check if element was added to right side successfully")
    public void addRight() {
        this.binaryTree.create(1);
        assertNull(this.binaryTree.getRight());
        this.binaryTree.addRight(2);
        assertNotNull(this.binaryTree.getRight());
        assertEquals(2, this.binaryTree.getRight().getValue());
    }

    @Test
    @DisplayName("Should check if element was removed to left side successfully")
    public void removeLeft() {
        this.binaryTree.create(1);
        this.binaryTree.addLeft(2);
        this.binaryTree.removeLeft();
        assertNull(this.binaryTree.getLeft());
    }

    @Test
    @DisplayName("Should check if element was removed to right side successfully")
    public void removeRight() {
        this.binaryTree.create(1);
        this.binaryTree.addRight(2);
        this.binaryTree.removeRight();
        assertNull(this.binaryTree.getRight());
    }

    @Test
    @DisplayName("Should get the element of the left side successfully")
    public void getLeft() {
        assertNull(this.binaryTree.getLeft());
        this.binaryTree.create(1);
        assertNull(this.binaryTree.getLeft());
        this.binaryTree.addLeft(2);
        assertNotNull(this.binaryTree.getLeft());
        assertEquals(2, this.binaryTree.getLeft().getValue());
    }

    @Test
    @DisplayName("Should get the element of the right side successfully")
    public void getRight() {
        assertNull(this.binaryTree.getRight());
        this.binaryTree.create(1);
        assertNull(this.binaryTree.getRight());
        this.binaryTree.addRight(2);
        assertNotNull(this.binaryTree.getRight());
        assertEquals(2, this.binaryTree.getRight().getValue());
    }
}
