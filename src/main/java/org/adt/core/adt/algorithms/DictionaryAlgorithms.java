package org.adt.core.adt.algorithms;

import org.adt.core.adt.definition.IDictionary;
import org.adt.core.adt.definition.ISet;
import org.adt.core.adt.implementation.normal.Dictionary;
import org.adt.core.adt.implementation.normal.Set;

public class DictionaryAlgorithms {

    public static void print(IDictionary dictionary) {
        ISet keys = dictionary.getKeys();
        while (!keys.isEmpty()) {
            int key = keys.choose();
            System.out.printf("key: %d, value: %d", key, dictionary.getValue(key));
            keys.remove(key);
        }
    }

    public static IDictionary counter(int[] array) {
        IDictionary dictionary = new Dictionary();

        for (int i = 0; i < array.length; i++) {
            if (!in(dictionary.getKeys(), array[i])) {
                dictionary.add(array[i], 1);
            } else {
                int total = dictionary.getValue(array[i]);
                dictionary.remove(array[i], total);
                total++;
                dictionary.add(array[i], total);
            }
        }

        return dictionary;
    }

    private static boolean in(ISet a, int element) {
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

}
