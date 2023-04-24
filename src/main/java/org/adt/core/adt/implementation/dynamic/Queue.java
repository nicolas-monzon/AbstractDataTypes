package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.implementation.dynamic.node.Node;

public class Queue implements IQueue {

    private Node first;

    @Override
    public void add(int a) {
        Node node = new Node(a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
    }

    @Override
    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return this.first.getValue();
    }
}
