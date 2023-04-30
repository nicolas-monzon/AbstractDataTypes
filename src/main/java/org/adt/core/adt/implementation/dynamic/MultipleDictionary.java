package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IMultipleDictionary;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.dynamic.node.MultipleDictionaryNode;
import org.adt.core.adt.implementation.normal.Set;

public class MultipleDictionary implements IMultipleDictionary {

    private MultipleDictionaryNode first;

    @Override
    public void add(int key, int value) {
        ISet set = new Set();
        set.add(value);
        if(this.first == null) {
            this.first = new MultipleDictionaryNode(key, set, null);
            return;
        }
        MultipleDictionaryNode candidate = this.first;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == key) {
                candidate.getValue().add(value);
                return;
            }
            candidate = candidate.getNext();
        }
        if(candidate.getKey() == key) {
            candidate.getValue().add(value);
            return;
        }
        candidate.setNext(new MultipleDictionaryNode(key, set, null));
    }

    @Override
    public void remove(int key, int value) {
        MultipleDictionaryNode backup = null;
        MultipleDictionaryNode candidate = this.first;
        while(candidate != null) {
            if(candidate.getKey() == key) {
                candidate.getValue().remove(value);
                if(candidate.getValue().isEmpty()) {
                    if(backup == null) {
                        if(candidate.getNext() == null) {
                            this.first = null;
                            return;
                        }
                        this.first = this.first.getNext();
                        return;
                    }
                    if(candidate.getNext() == null) {
                        backup.setNext(null);
                        return;
                    }
                    candidate.setNext(candidate.getNext().getNext());
                }
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public ISet getKeys() { // N^2
        ISet keySet = new Set(); // C
        MultipleDictionaryNode candidate = this.first; // C
        while(candidate != null) { // N * (N * C) = N^2 C = N^2
            keySet.add(candidate.getKey()); // N*C
            candidate = candidate.getNext();
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
            candidate = candidate.getNext();
        }
        return null; // Error
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
