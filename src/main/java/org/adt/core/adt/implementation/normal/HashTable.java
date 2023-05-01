package org.adt.core.adt.implementation.normal;

public class HashTable {

    private final int[][] buckets;
    private final int capacity;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new int[capacity][];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Integer key, Integer value) {
        int index = getBucketIndex(key);
        int[] bucket = buckets[index];
        if (bucket == null) {
            buckets[index] = new int[]{key, value};
            size++;
        } else {
            for (int i = 0; i < bucket.length; i += 2) {
                if (bucket[i] == key) {
                    bucket[i + 1] = value;
                    return;
                }
            }
            int[] newBucket = new int[bucket.length + 2];
            System.arraycopy(bucket, 0, newBucket, 0, bucket.length);
            newBucket[bucket.length] = key;
            newBucket[bucket.length + 1] = value;
            buckets[index] = newBucket;
            size++;
        }
    }

    public Integer get(Integer key) {
        int index = getBucketIndex(key);
        int[] bucket = buckets[index];
        if (bucket != null) {
            for (int i = 0; i < bucket.length; i += 2) {
                if (bucket[i] == key) {
                    return bucket[i + 1];
                }
            }
        }
        return null;
    }

    public void remove(Integer key) {
        int index = getBucketIndex(key);
        int[] bucket = buckets[index];
        if (bucket != null) {
            for (int i = 0; i < bucket.length; i += 2) {
                if (bucket[i] == key) {
                    int[] newBucket = new int[bucket.length - 2];
                    System.arraycopy(bucket, 0, newBucket, 0, i);
                    System.arraycopy(bucket, i + 2, newBucket, i, bucket.length - i - 2);
                    buckets[index] = newBucket;
                    size--;
                    return;
                }
            }
        }
    }

    private int getBucketIndex(Integer key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }
}