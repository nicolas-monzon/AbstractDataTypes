package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.INaryTree;
import org.adt.core.adt.implementation.dynamic.node.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class NaryTree implements INaryTree {

    private NaryTreeNode root;

    @Override
    public void create(int value) {
        this.root = new NaryTreeNode(value, new ArrayList<>());
    }

    @Override
    public Integer getValue() {
        return this.root.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void add(int value, int index) {
        int size = this.root.getChildren().size();

        INaryTree naryTree = new NaryTree();
        naryTree.create(value);
        if (size == index) {
            this.root.getChildren().add(naryTree);
            return;
        }

        List<INaryTree> aux = new ArrayList<>();
        if (size > index) {
            for (int i = 0; i < size; i++) {
                aux.add((i == index) ? naryTree : this.root.getChildren().get(i));
            }
            this.root.setChildren(aux);
            return;
        }

        for (int i = size; i < index; i++) {
            aux.add(null);
        }
        aux.add(naryTree);
        this.root.setChildren(aux);
    }

    @Override
    public void remove(int index) {
        int size = this.root.getChildren().size();
        if (size <= index) {
            return;
        }
        this.root.getChildren().set(index, null);
    }

    @Override
    public INaryTree get(int index) {
        int size = this.root.getChildren().size();
        if (index > size) {
            throw new RuntimeException("Error");
        }
        return this.root.getChildren().get(index);
    }

    @Override
    public List<INaryTree> getChildren() {
        return this.root.getChildren();
    }
}
