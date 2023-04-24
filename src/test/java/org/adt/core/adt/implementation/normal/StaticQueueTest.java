package org.adt.core.adt.implementation.normal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticQueueTest {

    @Test
    @DisplayName("Should add an arbitrary element first in the queue successfully")
    public void add() {
        Queue staticQueue = new Queue();
        assertTrue(staticQueue.isEmpty());
        assertDoesNotThrow(() -> staticQueue.add(1));
        assertFalse(staticQueue.isEmpty());
        assertEquals(1, staticQueue.getFirst());

        staticQueue.add(2);
        assertEquals(1, staticQueue.getFirst());

        staticQueue.remove();
        assertEquals(2, staticQueue.getFirst());
    }

}
