package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IMultipleDictionary;
import org.adt.core.adt.definition.ISet;

import java.util.Arrays;

public class MultipleDictionary implements IMultipleDictionary {
    private int[] keys;
    private ISet[] values;
    private int size;

    public MultipleDictionary() {
        this.keys = new int[10000];
        this.values = new Set[10000];
        this.size = 0;
    }

    @Override
    public void add(int key, int value) {
        int index = indexOfKey(key);
        if (index != -1) {
            this.values[index].add(value);
            return;
        }
        if (this.size == this.keys.length) {
            // Si el array de keys está lleno, se duplica su tamaño
            this.keys = Arrays.copyOf(this.keys, this.keys.length * 2);
            this.values = Arrays.copyOf(this.values, this.values.length * 2);
        }
        this.keys[this.size] = key;
        this.values[this.size] = new Set();
        this.values[this.size].add(value);
        this.size++;
    }

    @Override
    public void remove(int key, int value) {
        int index = indexOfKey(key);
        if (index != -1 && this.existsValue(this.values[index], value)) {
            this.values[index].remove(value);
            if (this.values[index].isEmpty()) {
                for (int i = index; i < this.size - 1; i++) {
                    this.keys[i] = this.keys[i + 1];
                    this.values[i] = this.values[i + 1];
                }
                this.size--;
            }
        }
    }

    private boolean existsValue(ISet set, int value) {
        ISet copy = new Set();
        boolean exists = false;
        while (!set.isEmpty()) {
            int element = set.choose();
            if (element == value) {
                exists = true;
                break;
            }
            copy.add(element);
            set.remove(element);
        }
        while (!copy.isEmpty()) {
            int element = copy.choose();
            set.add(element);
            copy.remove(element);
        }
        return exists;
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
    public ISet getValues(int key) {
        int index = indexOfKey(key);
        if (index != -1) {
            return this.values[index];
        }
        return null; // Error
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
