package org.adt.core.adt.utils;

import org.adt.core.adt.definition.*;
import org.adt.core.adt.implementation.SearchBinaryTree;
import org.adt.core.adt.implementation.dynamic.LinkedList;
import org.adt.core.adt.implementation.dynamic.NaryTree;
import org.adt.core.adt.implementation.normal.*;

import java.util.Random;

public class RandomizedStructures {

    private final static int MIN = -100;
    private final static int MAX = 100;

    private final static int TOTAL = 25;

    private static int randomInteger() {
        return (new Random()).nextInt(MIN, MAX);
    }

    public static LinkedList randomLinkedList() {
        LinkedList linkedList = new LinkedList();
        for(int i = 0; i < TOTAL; i++) {
            linkedList.add(randomInteger());
        }
        return linkedList;
    }

    public static IStack randomStack() {
        IStack stack = new Stack();
        for(int i = 0; i < TOTAL; i++) {
            stack.add(randomInteger());
        }
        return stack;
    }

    public static IQueue randomQueue() {
        IQueue queue = new Queue();
        for(int i = 0; i < TOTAL; i++) {
            queue.add(randomInteger());
        }
        return queue;
    }

    public static IPriorityQueue randomPriorityQueue() {
        IPriorityQueue priorityQueue = new PriorityQueue();
        for(int i = 0; i < TOTAL; i++) {
            priorityQueue.add(randomInteger(), randomInteger());
        }
        return priorityQueue;
    }

    public static ISet randomSet() {
        ISet set = new Set();
        for(int i = 0; i < TOTAL; i++) {
            set.add(randomInteger());
        }
        return set;
    }

    public static IDictionary randomDictionary() {
        IDictionary dictionary = new Dictionary();
        for(int i = 0; i < TOTAL; i++) {
            dictionary.add(randomInteger(), randomInteger());
        }
        return dictionary;
    }

    public static IMultipleDictionary randomMultipleDictionary() {
        IMultipleDictionary dictionary = new MultipleDictionary();
        for(int i = 0; i < TOTAL; i++) {
            int key = randomInteger();
            int totalValues = (new Random()).nextInt(1, 10);
            for(int j = 0; j < totalValues; j++) {
                dictionary.add(key, randomInteger());
            }
        }
        return dictionary;
    }

    public static HashTable randomHashTable() {
        HashTable hashTable = new HashTable();
        for(int i = 0; i < TOTAL; i++) {
            hashTable.put(randomInteger(), randomInteger());
        }
        return hashTable;
    }

    public static IBinaryTree randomBinaryTree() {
        IBinaryTree binaryTree = new BinaryTree();
        binaryTree.create(randomInteger());
        randomBinaryTree(binaryTree);
        return binaryTree;
    }

    private static void randomBinaryTree(IBinaryTree binaryTree) {
        if(Math.random() < 0.5) {
            binaryTree.addLeft(randomInteger());
            randomBinaryTree(binaryTree.getLeft());
        }
        if(Math.random() < 0.5) {
            binaryTree.addRight(randomInteger());
            randomBinaryTree(binaryTree.getRight());
        }
    }

    public static ISearchBinaryTree randomSBT() {
        ISearchBinaryTree sbt = new SearchBinaryTree();
        for(int i = 0; i < TOTAL; i++) {
            sbt.add(randomInteger());
        }
        return sbt;
    }

    public static INaryTree randomNaryTree() {
        INaryTree naryTree = new NaryTree();
        naryTree.create(randomInteger());
        randomNaryTree(naryTree);
        return naryTree;
    }

    private static void randomNaryTree(INaryTree naryTree) {
        int totalChild = (new Random()).nextInt(0, 3); // total children
        for(int i = 0; i < totalChild; i++) {
            naryTree.add(randomInteger(), i);
            randomNaryTree(naryTree.get(i));
        }
    }
}
