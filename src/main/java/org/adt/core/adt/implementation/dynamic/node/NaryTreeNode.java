package org.adt.core.adt.implementation.dynamic.node;

import org.adt.core.adt.implementation.dynamic.NaryTree;

import java.util.List;

public class NaryTreeNode {

    private int value;
    private List<NaryTree> children;

    public NaryTreeNode(int value, List<NaryTree> children) {
        this.value = value;
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<NaryTree> getChildren() {
        return children;
    }

    public void setChildren(List<NaryTree> children) {
        this.children = children;
    }
}
