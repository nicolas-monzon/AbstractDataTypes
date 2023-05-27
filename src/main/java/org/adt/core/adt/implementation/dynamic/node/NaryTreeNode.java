package org.adt.core.adt.implementation.dynamic.node;

import org.adt.core.adt.definition.INaryTree;
import org.adt.core.adt.implementation.dynamic.NaryTree;

import java.util.List;

public class NaryTreeNode {

    private int value;
    private List<INaryTree> children;

    public NaryTreeNode(int value, List<INaryTree> children) {
        this.value = value;
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<INaryTree> getChildren() {
        return children;
    }

    public void setChildren(List<INaryTree> children) {
        this.children = children;
    }
}
