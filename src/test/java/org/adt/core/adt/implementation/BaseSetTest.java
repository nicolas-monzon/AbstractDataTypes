package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.ISet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseSetTest {

    private ISet set;

    public abstract ISet getSet();

    @BeforeEach
    public void beforeEach() {
        this.set = this.getSet();
    }

    @Test
    @DisplayName("Should add an arbitrary element in the set successfully")
    public void add() {
        assertTrue(set.isEmpty());
        assertDoesNotThrow(() -> set.add(1));
        assertFalse(set.isEmpty());
        assertEquals(1, set.choose());

        set.add(2);
        int value = set.choose();
        assertTrue(value == 1 || value == 2);

        set.remove(2);
        assertEquals(1, set.choose());

        // test multiplicity
        set.add(1);
        set.remove(1);
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Should remove an arbitrary element of the set successfully")
    public void remove() {
        set.add(1);
        set.remove(1);
        assertTrue(set.isEmpty());
        set.add(1);
        set.add(2);
        set.remove(2);
        assertEquals(1, set.choose());

        // test of another element
        set.remove(3);
        assertEquals(1, set.choose());
    }

    @Test
    @DisplayName("Should check if exists an arbitrary element in the set successfully")
    public void isEmpty() {
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
        set.remove(1);
        assertTrue(set.isEmpty());

        set.add(1);
        set.add(2);
        set.remove(2);
        set.remove(1);
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Should choose a random element of the set successfully")
    public void choose() {
        // test 0 elements
        assertEquals(-1, set.choose());

        // test 1 element
        set.add(1);
        assertEquals(1, set.choose());

        // test n elements
        set.add(2);
        set.add(3);
        int value = set.choose();
        assertTrue(value >= 1);
        assertTrue(value <= 3);
    }

}
