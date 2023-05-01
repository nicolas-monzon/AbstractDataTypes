package org.adt.core.adt.examples.generic;

public class LinkedList<T> implements ILinkedList<T> {

    private Node<T> first;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node(value, null);
        if (this.first == null) {
            this.first = newNode;
            this.size++;
            return;
        }
        Node<T> candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(newNode);
        this.size++;
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            System.out.println("Error, rango excedido");
            return;
        }
        if (index == 0) {
            this.first = new Node<>(value, this.first);
            return;
        }
        int count = 1;
        Node<T> candidate = this.first;
        while (count != index) {
            candidate = candidate.getNext();
            count++;
        }
        candidate.setNext(new Node<>(value, candidate.getNext()));
    }

    @Override
    public void remove(int index) {
        if (this.first == null || index < 0 || index > size) {
            System.out.println("Error, rango excedido");
            return;
        }
        if (index == 0) {
            this.first = this.first.getNext();
            return;
        }
        int count = 1;
        Node<T> candidate = this.first;
        while (count != index) {
            candidate = candidate.getNext();
            count++;
        }
        candidate.setNext(candidate.getNext().getNext());
    }

    @Override
    public T get(int index) {
        if (this.first == null) {
            System.out.println("Error, lista vacia");
            return null;
        }
        if (index == 0) {
            return this.first.getValue();
        }
        int count = 0;
        Node<T> candidate = this.first;
        while (count != index) {
            candidate = candidate.getNext();
            count++;
        }
        return candidate.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
