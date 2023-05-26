package org.adt.core.adt.algorithms;

import org.adt.core.adt.implementation.dynamic.LinkedList;

public class LinkedListAlgorithms {

    public static void print(LinkedList linkedList) {
        for(int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }

}
