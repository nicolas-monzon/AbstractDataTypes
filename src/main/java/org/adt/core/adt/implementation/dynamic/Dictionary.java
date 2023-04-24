package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.implementation.dynamic.node.DictionaryNode;
import org.adt.core.adt.definition.IDictionary;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.normal.Set;

public class Dictionary implements IDictionary {

    private DictionaryNode first;
    private int size;

    public Dictionary() {
        size = 0;
    }

    @Override
    public void add(int key, int value) {
        DictionaryNode index = indexOfKey(key);
        if (index != null) {
            index.setValue(value); // Si la key ya existe, se reemplaza el value
            return;
        }
        index.setNext(new DictionaryNode(key, value, null));
        size++;
    }

    @Override
    public void remove(int key, int value) {
        if(this.first == null) {
            return;
        }
        if(this.first.getKey() == key && this.first.getValue() == value) {
            this.first = this.first.getNext();
            return;
        }
        DictionaryNode backup = null;
        DictionaryNode candidate = this.first;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == key && candidate.getValue() == value) {
                backup.setNext(candidate.getNext());
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
        if(candidate.getKey() == key && candidate.getValue() == value) {
            backup.setNext(null);
        }
    }

    @Override
    public ISet getKeys() {
        ISet keySet = new Set();
        DictionaryNode candidate = this.first;
        while(candidate != null) {
            keySet.add(candidate.getKey());
            if(candidate.getNext() != null) {
                candidate = candidate.getNext();
            }
        }
        return keySet;
    }

    @Override
    public int getValue(int key) {
        DictionaryNode candidate = this.first;
        while(candidate != null) {
            if(candidate.getKey() == key) {
                return candidate.getValue();
            }

            if(candidate.getNext() != null) {
                candidate = candidate.getNext();
            }
        }
        return -1; // Error
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private DictionaryNode indexOfKey(int key) {
        if(this.first == null) {
            return null;
        }
        DictionaryNode candidate = this.first;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == key) {
                return candidate;
            }
            candidate = candidate.getNext();
        }
        return null;
    }
}
