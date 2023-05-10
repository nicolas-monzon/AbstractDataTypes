package org.adt.core.adt.algorithms;

import org.adt.core.adt.definition.IPriorityQueue;
import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.normal.PriorityQueue;

public class PriorityQueueAlgorithms {

    public static void sort(IStack stack) {
        IPriorityQueue priorityQueue = new PriorityQueue();
        while (!stack.isEmpty()) {
            priorityQueue.add(stack.getTop(), stack.getTop());
            stack.remove();
        }
        while (!priorityQueue.isEmpty()) {
            stack.add(priorityQueue.getPriority());
            priorityQueue.remove();
        }
    }

}
