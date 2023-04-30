package org.adt.core.adt.implementation;

import java.util.ArrayList;
import java.util.List;

public class BPlusTree {

    private final Node root;
    private final int blockSize;

    public BPlusTree(int blockSize) {
        this.root = new LeafNode();
        this.blockSize = blockSize;
    }

    public void insert(int key, String value) {
        root.insert(key, value);
    }

    public String search(int key) {
        return root.search(key);
    }

    private abstract class Node {
        List<Integer> keys;

        Node() {
            keys = new ArrayList<>();
        }

        abstract void insert(int key, String value);

        abstract String search(int key);
    }

    private class InternalNode extends Node {
        List<Node> children;

        InternalNode() {
            super();
            children = new ArrayList<>();
        }

        @Override
        void insert(int key, String value) {
            int i = 0;
            while (i < keys.size() && key > keys.get(i)) {
                i++;
            }
            children.get(i).insert(key, value);
            if (children.get(i).keys.size() == blockSize) {
                splitChild(i);
            }
        }

        @Override
        String search(int key) {
            int i = 0;
            while (i < keys.size() && key > keys.get(i)) {
                i++;
            }
            return children.get(i).search(key);
        }

        private void splitChild(int index) {
            Node child = children.get(index);
            InternalNode newNode = new InternalNode();
            int mid = blockSize / 2;
            newNode.keys.addAll(child.keys.subList(mid, child.keys.size()));
            if(child instanceof InternalNode) {
                newNode.children.addAll(((InternalNode) child).children.subList(mid, ((InternalNode) child).children.size()));
                ((InternalNode) child).children.subList(mid, ((InternalNode) child).children.size()).clear();
            }
            child.keys.subList(mid, child.keys.size()).clear();
            keys.add(index, newNode.keys.get(0));
            children.add(index + 1, newNode);
        }
    }

    private class LeafNode extends Node {
        List<String> values;
        LeafNode next;

        LeafNode() {
            super();
            values = new ArrayList<>();
        }

        @Override
        void insert(int key, String value) {
            int i = 0;
            while (i < keys.size() && key > keys.get(i)) {
                i++;
            }
            keys.add(i, key);
            values.add(i, value);
            if (keys.size() == blockSize) {
                splitLeaf();
            }
        }

        @Override
        String search(int key) {
            int i = 0;
            while (i < keys.size() && key > keys.get(i)) {
                i++;
            }
            if (i < keys.size() && key == keys.get(i)) {
                return values.get(i);
            } else {
                return null;
            }
        }

        private void splitLeaf() {
            LeafNode newLeaf = new LeafNode();
            newLeaf.next = this.next;
            this.next = newLeaf;
            int mid = blockSize / 2;
            newLeaf.keys.addAll(keys.subList(mid, blockSize));
            newLeaf.values.addAll(values.subList(mid, blockSize));
            keys.subList(mid, blockSize).clear();
            values.subList(mid, blockSize).clear();
        }
    }
}