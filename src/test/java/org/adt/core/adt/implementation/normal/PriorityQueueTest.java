package org.adt.core.adt.implementation.normal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    @Test
    @DisplayName("Should add an arbitrary element first in the priority queue successfully")
    public void add() {
        // test 1 element
        PriorityQueue priorityQueue = new PriorityQueue();
        assertTrue(priorityQueue.isEmpty());
        priorityQueue.add(1,2);
        assertFalse(priorityQueue.isEmpty());

        // test 2 elements
        priorityQueue.add(1, 1);
        priorityQueue.remove();
        assertEquals(1, priorityQueue.getFirst());
        assertEquals(2, priorityQueue.getPriority());

        // test N elements
        priorityQueue.add(-1,3);
        priorityQueue.add(5,-2);
        priorityQueue.add(0,0);

        assertEquals(5, priorityQueue.getFirst());
        assertEquals(-2, priorityQueue.getPriority());

        priorityQueue.remove();
        assertEquals(0, priorityQueue.getFirst());
        assertEquals(0, priorityQueue.getPriority());

        priorityQueue.remove();
        assertEquals(1, priorityQueue.getFirst());
        assertEquals(2, priorityQueue.getPriority());

        priorityQueue.remove();
        assertEquals(-1, priorityQueue.getFirst());
        assertEquals(3, priorityQueue.getPriority());
    }

    @Test
    @DisplayName("Should remove the first element successfully")
    public void remove() {
        PriorityQueue priorityQueue = new PriorityQueue();

        // test 0 elements
        assertDoesNotThrow(priorityQueue::remove);

        // test 1 element
        priorityQueue.add(1,2);
        priorityQueue.remove();
        assertTrue(priorityQueue.isEmpty());

        // test 2 elements
        priorityQueue.add(1, 1);
        priorityQueue.add(2, 2);
        priorityQueue.remove();
        assertEquals(2, priorityQueue.getFirst());
        assertEquals(2, priorityQueue.getPriority());

        // test N elements
        priorityQueue.add(3,3);
        priorityQueue.add(4,4);
        priorityQueue.remove();

        assertEquals(3, priorityQueue.getFirst());
        assertEquals(3, priorityQueue.getPriority());
    }

    @Test
    @DisplayName("Should check is not exists elements successfully")
    public void isEmpty() {
        PriorityQueue priorityQueue = new PriorityQueue();
        assertTrue(priorityQueue.isEmpty());
        priorityQueue.add(3, 1);
        assertFalse(priorityQueue.isEmpty());
    }

    @Test
    @DisplayName("Should get the first element successfully")
    public void getFirst() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(3, 1);
        assertEquals(3, priorityQueue.getFirst());
        priorityQueue.add(4, 0);
        assertEquals(4, priorityQueue.getFirst());
    }

    @Test
    @DisplayName("Should get the priority of the first element successfully")
    public void getPriority() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(3, 1);
        assertEquals(1, priorityQueue.getPriority());
        priorityQueue.add(4, 0);
        assertEquals(0, priorityQueue.getPriority());
    }

}
