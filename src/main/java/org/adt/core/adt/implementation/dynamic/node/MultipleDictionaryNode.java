package org.adt.core.adt.implementation.dynamic.node;

import org.adt.core.adt.definition.ISet;

public class MultipleDictionaryNode {

    private int key;
    private ISet value;
    private MultipleDictionaryNode next;

    public MultipleDictionaryNode(int key, ISet value, MultipleDictionaryNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ISet getValue() {
        return value;
    }

    public void setValue(ISet value) {
        this.value = value;
    }

    public MultipleDictionaryNode getNext() {
        return next;
    }

    public void setNext(MultipleDictionaryNode next) {
        this.next = next;
    }
}
