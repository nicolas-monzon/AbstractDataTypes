package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.BaseSetTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SetTest extends BaseSetTest {

    @Override
    public ISet getSet() {
        return new Set();
    }

    @DisplayName("Should check if two sets with same elements return true in the equals method")
    @Test
    public void equals() {
        Set a = new Set();
        Set b = new Set();
        assertEquals(a, b);
        a.add(1);
        assertNotEquals(a, b);
        b.add(1);
        assertEquals(a, b);
        a.add(2);
        a.add(3);
        a.add(4);
        b.add(4);
        b.add(2);
        b.add(3);
        assertEquals(a, b);
    }
}
