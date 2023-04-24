package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.dynamic.node.Node;

import java.util.Random;

public class Set implements ISet {

    private Node first;
    private int count;

    @Override
    public void add(int a) { // N * C
        if(this.first == null) { // C
            this.first = new Node(a, null); // C
            return;
        }

        if(this.first.getValue() == a) { // C
            return;
        }

        Node candidate = this.first; // C
        while(candidate.getNext() != null) { // N * C
            candidate = candidate.getNext(); // C
            if(candidate.getValue() == a) { // C 
                return;
            }
        }
        candidate.setNext(new Node(a, null)); // C
        this.count++; // C
    }

    @Override
    public void remove(int a) {
        if(this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if(this.first != null && this.first.getNext() == null) {
            this.first = null;
            this.count--;
            return;
        }

        Node backup;
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            backup = candidate;
            candidate = candidate.getNext();
            if(candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int choose() {
        if(this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for(int i = 0; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }
}
