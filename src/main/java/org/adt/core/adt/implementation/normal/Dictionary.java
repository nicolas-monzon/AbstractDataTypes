package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IDictionary;
import org.adt.core.adt.definition.ISet;

import java.util.Arrays;

public class Dictionary implements IDictionary {

    private int[] keys;
    private int[] values;
    private int size;

    public Dictionary() {
        this.keys = new int[10000];
        this.values = new int[10000];
        this.size = 0;
    }

    @Override
    public void add(int key, int value) {
        int index = indexOfKey(key);
        if (index != -1) {
            this.values[index] = value; // Si la key ya existe, se reemplaza el value
            return;
        }
        if (this.size == this.keys.length) {
            // Si el array de keys está lleno, se duplica su tamaño
            this.keys = Arrays.copyOf(this.keys, this.keys.length * 2);
            this.values = Arrays.copyOf(this.values, this.values.length * 2);
        }
        this.keys[this.size] = key;
        this.values[this.size] = value;
        this.size++;
    }

    @Override
    public void remove(int key, int value) {
        int index = indexOfKey(key);
        if (index != -1 && this.values[index] == value) {
            for (int i = index; i < this.size - 1; i++) {
                this.keys[i] = this.keys[i + 1];
                this.values[i] = this.values[i + 1];
            }
            this.size--;
        }
    }

    @Override
    public ISet getKeys() {
        ISet keySet = new Set();
        for (int i = 0; i < this.size; i++) {
            keySet.add(this.keys[i]);
        }
        return keySet;
    }

    @Override
    public int getValue(int key) {
        int index = indexOfKey(key);
        if (index != -1) {
            return this.values[index];
        }
        return -1; // Error
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private int indexOfKey(int key) {
        for (int i = 0; i < this.size; i++) {
            if (this.keys[i] == key) {
                return i;
            }
        }
        return -1;
    }
}