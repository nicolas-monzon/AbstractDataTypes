package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.IStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseStackTest {

    private IStack stack;

    public abstract IStack getStack();

    @BeforeEach
    public void beforeEach() {
        this.stack = this.getStack();
    }

    @Test
    @DisplayName("Should add an arbitrary element in the top of the stack successfully")
    public void add() {
        assertTrue(stack.isEmpty());
        assertDoesNotThrow(() -> stack.add(1));
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getTop());

        stack.add(2);
        assertEquals(2, stack.getTop());

        stack.remove();
        assertEquals(1, stack.getTop());
    }

    @Test
    @DisplayName("Should remove the top element successfully")
    public void remove() {
        // test 0 elements
        assertDoesNotThrow(stack::remove);

        // test 1 element
        stack.add(1);
        stack.remove();
        assertTrue(stack.isEmpty());

        // test 2 elements
        stack.add(1);
        stack.add(2);
        stack.remove();
        assertEquals(1, stack.getTop());

        // test N elements
        stack.add(3);
        stack.add(4);
        stack.remove();

        assertEquals(3, stack.getTop());
    }

    @Test
    @DisplayName("Should check is not exists elements successfully")
    public void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.add(3);
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Should get the top element successfully")
    public void getTop() {
        assertEquals(-1, stack.getTop());

        stack.add(3);
        assertEquals(3, stack.getTop());
        stack.add(4);
        assertEquals(4, stack.getTop());
    }

}
