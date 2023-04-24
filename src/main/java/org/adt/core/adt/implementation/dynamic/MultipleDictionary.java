package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IMultipleDictionary;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.dynamic.node.MultipleDictionaryNode;
import org.adt.core.adt.implementation.normal.Set;

public class MultipleDictionary implements IMultipleDictionary {

    private MultipleDictionaryNode first;
    private int size;

    public MultipleDictionary() {
        size = 0;
    }

    @Override
    public void add(int key, int value) {
        // TODO
    }

    @Override
    public void remove(int key, int value) {
        // TODO
    }

    @Override
    public ISet getKeys() { // N^2
        ISet keySet = new Set(); // C
        MultipleDictionaryNode candidate = this.first; // C
        while(candidate != null) { // N * (N * C) = N^2 C = N^2
            keySet.add(candidate.getKey()); // N*C
            if(candidate.getNext() != null) { // C
                candidate = candidate.getNext(); // C
            }
        }
        return keySet; // C
    }

    @Override
    public ISet getValues(int key) {
        MultipleDictionaryNode candidate = this.first;
        while(candidate != null) {
            if(candidate.getKey() == key) {
                return candidate.getValue();
            }

            if(candidate.getNext() != null) {
                candidate = candidate.getNext();
            }
        }
        return null; // Error
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private MultipleDictionaryNode indexOfKey(int key) {
        if(this.first == null) {
            return null;
        }
        MultipleDictionaryNode candidate = this.first;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == key) {
                return candidate;
            }
            candidate = candidate.getNext();
        }
        return null;
    }
}
