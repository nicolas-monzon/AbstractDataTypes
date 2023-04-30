package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.IQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseQueueTest {

    private IQueue queue;

    public abstract IQueue getQueue();

    @BeforeEach
    public void beforeEach() {
        this.queue = this.getQueue();
    }

    @Test
    @DisplayName("Should add an arbitrary element first in the queue successfully")
    public void add() {
        assertTrue(queue.isEmpty());
        assertDoesNotThrow(() -> queue.add(1));
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.getFirst());

        queue.add(2);
        assertEquals(1, queue.getFirst());

        queue.remove();
        assertEquals(2, queue.getFirst());
    }

    @Test
    @DisplayName("Should remove the first element successfully")
    public void remove() {
        // test 0 elements
        assertDoesNotThrow(queue::remove);

        // test 1 element
        queue.add(1);
        queue.remove();
        assertTrue(queue.isEmpty());

        // test 2 elements
        queue.add(1);
        queue.add(2);
        queue.remove();
        assertEquals(2, queue.getFirst());

        // test N elements
        queue.add(3);
        queue.add(4);
        queue.remove();

        assertEquals(3, queue.getFirst());
    }

    @Test
    @DisplayName("Should check is not exists elements successfully")
    public void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.add(3);
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Should get the first element successfully")
    public void getFirst() {
        assertEquals(-1, queue.getFirst());

        queue.add(3);
        assertEquals(3, queue.getFirst());
        queue.add(4);
        assertEquals(3, queue.getFirst());
    }

}
