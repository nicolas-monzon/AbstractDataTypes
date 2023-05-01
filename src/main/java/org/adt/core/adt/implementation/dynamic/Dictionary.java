package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IDictionary;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.dynamic.node.DictionaryNode;
import org.adt.core.adt.implementation.normal.Set;

public class Dictionary implements IDictionary {

    private DictionaryNode first;
    private int size;

    public Dictionary() {
        size = 0;
    }

    @Override
    public void add(int key, int value) {
        if (this.first == null) {
            this.first = new DictionaryNode(key, value, null);
            this.size++;
            return;
        }
        DictionaryNode index = indexOfKey(key);
        if (index != null) {
            index.setValue(value); // Si la key ya existe, se reemplaza el value
            return;
        }
        DictionaryNode lastNode = this.first;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        lastNode.setNext(new DictionaryNode(key, value, null));
        this.size++;
    }

    @Override
    public void remove(int key, int value) {
        if (this.first == null) {
            return;
        }
        if (this.first.getKey() == key && this.first.getValue() == value) {
            this.first = this.first.getNext();
            this.size--;
            return;
        }
        DictionaryNode backup = null;
        DictionaryNode candidate = this.first;
        while (candidate.getNext() != null) {
            if (candidate.getKey() == key && candidate.getValue() == value) {
                backup.setNext(candidate.getNext());
                this.size--;
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
        if (candidate.getKey() == key && candidate.getValue() == value) {
            backup.setNext(null);
            this.size--;
        }
    }

    @Override
    public ISet getKeys() {
        ISet keySet = new Set();
        DictionaryNode candidate = this.first;
        while (candidate != null) {
            keySet.add(candidate.getKey());
            candidate = candidate.getNext();
        }
        return keySet;
    }

    @Override
    public int getValue(int key) {
        DictionaryNode candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                return candidate.getValue();
            }

            candidate = candidate.getNext();
        }
        return -1; // Error
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private DictionaryNode indexOfKey(int key) {
        if (this.first == null) {
            return null;
        }
        DictionaryNode candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                return candidate;
            }
            candidate = candidate.getNext();
        }
        return null;
    }
}
