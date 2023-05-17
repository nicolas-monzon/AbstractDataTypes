package org.adt.core.adt.algorithms;

import org.adt.core.adt.definition.IQueue;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.normal.Set;

public class SetAlgorithms {

    public static void print(ISet set) {
        while (!set.isEmpty()) {
            int element = set.choose();
            System.out.println(element);
            set.remove(element);
        }
    }

    public static boolean in(ISet a, int element) {
        ISet aux = new Set();
        boolean exists = false;
        while(!a.isEmpty()) {
            int value = a.choose();
            if(element == value) {
                exists = true;
                break;
            }
            aux.add(value);
            a.remove(value);
        }
        while(!aux.isEmpty()) {
            int value = aux.choose();
            a.add(value);
            aux.remove(value);
        }
        return exists;
    }

    public static boolean equals(ISet a, ISet b) {
        ISet aux = new Set();
        boolean equals = true;
        while(!a.isEmpty()) {
            int element = a.choose();
            if(!in(b, element)) {
                equals = false;
                break;
            }
            aux.add(element);
            a.remove(element);
            b.remove(element);
        }
        if(!b.isEmpty()) {
            equals = false;
        }
        while(!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            b.add(element);
            aux.remove(element);
        }
        return equals;
    }

    public static boolean subset(ISet a, ISet b) {
        ISet aux = new Set();
        boolean subset = true;
        while(!a.isEmpty()) {
            int element = a.choose();
            if(!in(b, element)) {
                subset = false;
                break;
            }
            aux.add(element);
            a.remove(element);
            b.remove(element);
        }
        if(b.isEmpty()) {
            subset = false;
        }
        while(!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            b.add(element);
            aux.remove(element);
        }
        return subset;
    }

    public static boolean subseteq(ISet a, ISet b) {
        return subset(a, b) || equals(a, b);
    }

    public static ISet union(ISet a, ISet b) {
        ISet aux = new Set();
        ISet result = new Set();
        while(!a.isEmpty()) {
            int element = a.choose();
            aux.add(element);
            result.add(element);
            a.remove(element);
        }
        while(!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            aux.remove(element);
        }
        while(!b.isEmpty()) {
            int element = b.choose();
            aux.add(element);
            result.add(element);
            b.remove(element);
        }
        while(!aux.isEmpty()) {
            int element = aux.choose();
            b.add(element);
            aux.remove(element);
        }
        return result;
    }

    public static ISet unionAll(ISet[] sets) {
        ISet result = new Set(); // empty set
        for (ISet set : sets) {
            result = union(set, result);
        }
        return result;
    }

}
