package org.adt.core.adt.algorithms;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.normal.Stack;

public class StackAlgorithms {

    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }

    public static IStack copy(IStack stack) {
        IStack copy = new Stack();
        IStack aux = new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            copy.add(aux.getTop());
            aux.remove();
        }
        return copy;
    }

    public static void revert(IStack stack) {
        IStack aux = new Stack();
        IStack aux2 = new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            aux2.add(aux.getTop());
            aux.remove();
        }
        while (!aux2.isEmpty()) {
            stack.add(aux2.getTop());
            aux2.remove();
        }
    }

}
