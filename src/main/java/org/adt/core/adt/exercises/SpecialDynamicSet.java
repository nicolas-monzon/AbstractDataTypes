package org.adt.core.adt.exercises;

import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.dynamic.node.Node;

import java.util.Random;

public class SpecialDynamicSet implements ISet {

    private Node first;
    private int count;

    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new Node(a, null);
            return;
        }

        if (this.first.getValue() == a) {
            return;
        }

        int total = 0;
        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                total++;
            }
            if ((a % 2 == 1 && total == 1) || (a % 2 == 0 && total == 3)) {
                return;
            }
        }
        candidate.setNext(new Node(a, null));
    }

    @Override
    public void remove(int a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        Node backup;
        Node candidate = this.first;
        while (candidate.getNext() != null) {
            backup = candidate;
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
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
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        Node candidate = this.first;
        for (int i = 0; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }
}
