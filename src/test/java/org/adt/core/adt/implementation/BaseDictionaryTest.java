package org.adt.core.adt.implementation;

import org.adt.core.adt.definition.IDictionary;
import org.adt.core.adt.definition.ISet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseDictionaryTest {

    private IDictionary dictionary;

    public abstract IDictionary getDictionary();

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
        assertEquals(2, this.dictionary.getValue(1));

        // Element that exists in the dictionary
        this.dictionary.add(1, 3);
        assertFalse(this.dictionary.isEmpty());
        assertEquals(1, this.dictionary.getKeys().choose());
        assertEquals(3, this.dictionary.getValue(1));

        // N pairs
        this.dictionary.add(2, 3);
        assertEquals(3, this.dictionary.getValue(2));

        this.dictionary.add(3, 3);
        assertEquals(3, this.dictionary.getValue(3));
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
        this.dictionary.add(1, 1);
        assertEquals(1,  this.dictionary.getValue(1));
        this.dictionary.add(1, 2);
        assertEquals(2,  this.dictionary.getValue(1));
        this.dictionary.add(3, 3);
        assertEquals(3,  this.dictionary.getValue(3));
        this.dictionary.remove(3, 3);
        assertEquals(-1,  this.dictionary.getValue(3));
    }

    @Test
    @DisplayName("Should check if exists pairs keys-value in the dictionary")
    public void isEmpty() {
        assertTrue(this.dictionary.isEmpty());
        this.dictionary.add(1, 1);
        assertFalse(this.dictionary.isEmpty());
    }
}
