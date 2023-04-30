package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.IMultipleDictionary;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.normal.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public abstract class BaseMultipleDictionaryTest {

    private IMultipleDictionary dictionary;

    public abstract IMultipleDictionary getDictionary();

    @BeforeEach
    public void beforeEach() {
        this.dictionary = this.getDictionary();
    }

    @Test
    @DisplayName("Should add an arbitrary pair key-value in the dictionary")
    public void add() {
        assertTrue(this.dictionary.isEmpty());
        this.dictionary.add(1, 2);
        assertFalse(this.dictionary.isEmpty());
        assertEquals(1, this.dictionary.getKeys().choose());
        ISet result = new Set();
        result.add(2);
        assertEquals(result, this.dictionary.getValues(1));

        // Element that exists in the dictionary
        this.dictionary.add(1, 3);
        assertFalse(this.dictionary.isEmpty());
        assertEquals(1, this.dictionary.getKeys().choose());
        ISet result2 = new Set();
        result2.add(2);
        result2.add(3);
        assertEquals(result2, this.dictionary.getValues(1));

        // N pairs
        this.dictionary.add(2, 3);
        ISet result3 = new Set();
        result3.add(3);
        assertEquals(result3, this.dictionary.getValues(2));

        this.dictionary.add(3, 3);
        assertEquals(result3, this.dictionary.getValues(3));

        // Multiples values per key
        this.dictionary.add(3, 4);
        this.dictionary.add(3, 5);
        this.dictionary.add(3, 6);
        result3.add(4);
        result3.add(5);
        result3.add(6);
        assertEquals(result3, this.dictionary.getValues(3));

        // Add existing element
        this.dictionary.add(3, 6);
        assertEquals(result3, this.dictionary.getValues(3));
    }

    @Test
    @DisplayName("Should remove an arbitrary pair key-value in the dictionary")
    public void remove() {
        // 0 elements
        assertDoesNotThrow(() -> this.dictionary.remove(1, 1));

        // 1 element, there is key, there is value
        this.dictionary.add(1, 1);
        this.dictionary.remove(1, 1);
        assertTrue(this.dictionary.isEmpty());

        // 1 element, there is key, there isn't value
        this.dictionary.add(1, 1);
        this.dictionary.remove(1, 2);
        assertFalse(this.dictionary.isEmpty());

        // 1 element, there isn't, there is value
        this.dictionary.remove(2, 1);
        assertFalse(this.dictionary.isEmpty());

        // 1 element, there isn't, there isn't value
        this.dictionary.remove(2, 2);
        assertFalse(this.dictionary.isEmpty());

        // N elements
        this.dictionary.add(2, 2);
        this.dictionary.remove(1, 1);
        assertEquals(2, this.dictionary.getKeys().choose());

        // Existing elements
        this.dictionary.add(2, 3);
        this.dictionary.remove(2, 2);
        assertEquals(2, this.dictionary.getKeys().choose());
        ISet result = new Set();
        result.add(3);
        assertEquals(result, this.dictionary.getValues(2));
    }

    @Test
    @DisplayName("Should get all keys in the dictionary")
    public void getKeys() {
        assertTrue(this.dictionary.getKeys().isEmpty());
        this.dictionary.add(1, 1);
        assertEquals(1, this.dictionary.getKeys().choose());
        this.dictionary.add(2, 2);
        this.dictionary.add(3, 3);
        int[] keys = new int[3];
        int count = 0;

        ISet actualKeys = this.dictionary.getKeys();
        while (!actualKeys.isEmpty()) {
            keys[count] = actualKeys.choose();
            actualKeys.remove(keys[count]);
            count++;
        }
        Arrays.sort(keys);

        count = 1;
        for(int key : keys) {
            assertEquals(count, key);
            count++;
        }
    }

    @Test
    @DisplayName("Should get value by key successfully")
    public void getValue() {
        ISet result = new Set();
        result.add(1);
        this.dictionary.add(1, 1);
        assertEquals(result,  this.dictionary.getValues(1));
        this.dictionary.add(1, 2);
        result.add(2);
        assertEquals(result,  this.dictionary.getValues(1));
        this.dictionary.add(3, 3);
        ISet result2 = new Set();
        result2.add(3);
        assertEquals(result2,  this.dictionary.getValues(3));
        this.dictionary.remove(3, 3);
        assertNull(this.dictionary.getValues(3));
    }

    @Test
    @DisplayName("Should check if exists pairs keys-value in the dictionary")
    public void isEmpty() {
        assertTrue(this.dictionary.isEmpty());
        this.dictionary.add(1, 1);
        assertFalse(this.dictionary.isEmpty());
    }
}
