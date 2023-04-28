package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IPriorityQueue;
import org.adt.core.adt.implementation.dynamic.node.PriorityNode;

public class PriorityQueue implements IPriorityQueue {

    private PriorityNode first;

    @Override
    public void add(int a, int priority) {
        if (this.first == null) { // 0 elements
            this.first = new PriorityNode(a, priority, null);
            return;
        }

        if (this.first.getNext() == null) { // 1 element
            if (this.first.getPriority() > priority) {
                this.first = new PriorityNode(a, priority, this.first);
            } else {
                this.first.setNext(new PriorityNode(a, priority, null));
            }
            return;
        }

        // n elements

        // 1° check first element:
        if (this.first.getPriority() > priority) {
            this.first = new PriorityNode(a, priority, this.first);
            return;
        }

        PriorityNode backup = this.first;
        PriorityNode candidate = this.first.getNext();
        while(candidate.getNext() != null) {
            if(candidate.getPriority() > priority) {
                backup.setNext(new PriorityNode(a, priority, candidate));
                return;
            }
            candidate = candidate.getNext();
        }
        if(candidate.getPriority() > priority) {
            backup.setNext(new PriorityNode(a, priority, null));
        }
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

    @Override
    public int getPriority() {
        if(this.first == null) {
            System.out.println("No se puede obtener la prioridad del primero una cola vacia");
            return -1;
        }
        return this.first.getPriority();
    }
}
