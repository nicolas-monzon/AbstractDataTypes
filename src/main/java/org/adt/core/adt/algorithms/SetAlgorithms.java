package org.adt.core.adt.algorithms;

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
        while (!a.isEmpty()) {
            int value = a.choose();
            if (element == value) {
                exists = true;
                break;
            }
            aux.add(value);
            a.remove(value);
        }
        while (!aux.isEmpty()) {
            int value = aux.choose();
            a.add(value);
            aux.remove(value);
        }
        return exists;
    }

    public static boolean equals(ISet a, ISet b) {
        ISet aux = new Set();
        boolean equals = true;
        while (!a.isEmpty()) {
            int element = a.choose();
            if (!in(b, element)) {
                equals = false;
                break;
            }
            aux.add(element);
            a.remove(element);
            b.remove(element);
        }
        if (!b.isEmpty()) {
            equals = false;
        }
        while (!aux.isEmpty()) {
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
        while (!a.isEmpty()) {
            int element = a.choose();
            if (!in(b, element)) {
                subset = false;
                break;
            }
            aux.add(element);
            a.remove(element);
            b.remove(element);
        }
        if (b.isEmpty()) {
            subset = false;
        }
        while (!aux.isEmpty()) {
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
        while (!a.isEmpty()) {
            int element = a.choose();
            aux.add(element);
            result.add(element);
            a.remove(element);
        }
        while (!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            aux.remove(element);
        }
        while (!b.isEmpty()) {
            int element = b.choose();
            aux.add(element);
            result.add(element);
            b.remove(element);
        }
        while (!aux.isEmpty()) {
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

    public static ISet intersection(ISet a, ISet b) {
        ISet aux = new Set();
        ISet result = new Set();
        while (!a.isEmpty()) {
            int element = a.choose();
            aux.add(element);
            if (in(b, element)) {
                result.add(element);
            }
            a.remove(element);
        }
        while (!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            aux.remove(element);
        }
        return result;
    }

    public static ISet intersectionAll(ISet[] sets) {
        if (sets == null || sets.length == 0) {
            return new Set();
        }
        ISet result = sets[0];
        for (int i = 1; i < sets.length; i++) {
            result = intersection(sets[i], result);
        }
        return result;
    }

    public static ISet difference(ISet a, ISet b) {
        ISet aux = new Set();
        ISet result = new Set();
        while (!a.isEmpty()) {
            int element = a.choose();
            aux.add(element);
            if (!in(b, element)) {
                result.add(element);
            }
            a.remove(element);
        }
        while (!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            aux.remove(element);
        }
        return result;
    }

    public static ISet symmetricDifferenceV1(ISet a, ISet b) {
        return difference(union(a, b), intersection(a, b));
    }

    public static ISet symmetricDifferenceV2(ISet a, ISet b) {
        return union(difference(a, b), difference(b, a));
    }

    public static int cardinality(ISet a) {
        ISet aux = new Set();
        int count = 0;
        while (!a.isEmpty()) {
            int element = a.choose();
            aux.add(element);
            a.remove(element);
            count++;
        }
        return count;
    }

    private static String decimalToBinary(int n, int digits) {
        String candidate = "";
        while (n != 0) {
            candidate += n % 2;
            n = n / 2;
        }
        while (candidate.length() < digits) {
            candidate += "0";
        }
        return (new StringBuilder(candidate)).reverse().toString();
    }

    public static ISet[] parts(ISet set) {
        int cardinality = cardinality(set);
        int limit = (int) Math.pow(2, cardinality);

        int[] values = new int[cardinality];
        int count = 0;
        ISet aux = new Set();
        while (!set.isEmpty()) {
            int element = set.choose();
            values[count] = element;
            aux.add(element);
            set.remove(element);
            count++;
        }
        while (!aux.isEmpty()) {
            int element = aux.choose();
            set.add(element);
            aux.remove(element);
        }

        ISet[] result = new Set[limit];
        for (int i = 0; i < limit; i++) {
            String binary = decimalToBinary(i, cardinality);
            ISet part = new Set();
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    part.add(values[j]);
                }
            }
            result[i] = part;
        }

        return result;
    }

}
