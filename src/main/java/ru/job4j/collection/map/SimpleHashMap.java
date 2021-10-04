package ru.job4j.collection.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private final static float LOAD_FACTOR = 0.6f;
    private Node<K, V>[] table;
    private int size = 0;
    private int modCount = 0;

    @SuppressWarnings("MoveFieldAssignmentToInitializer")
    public SimpleHashMap() {
        this.table = new Node[3];
    }

    public boolean insert(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resizeTable();
        }
        boolean rsl = false;
        int index = indexOfBucket(key);
        Node<K, V> newNode = new Node<>(hash(key), key, value);
        if (table[index] == null) {
            table[index] = newNode;
            size++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    public V get(K key) {
        V rsl = null;
        int index = indexOfBucket(key);
        if (table[index] != null) {
            if (table[index].key.equals(key)) {
                rsl = table[index].value;
            }
        }
        return rsl;
    }

    public boolean delete(K key) {
        boolean rsl = false;
        int index = indexOfBucket(key);
        if (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                size--;
                modCount++;
                rsl = true;
            }
        }
        return rsl;
    }

    private Node<K, V>[] resizeTable() {
        Node<K, V>[] oldTable = table;
        Node<K, V>[] newTable = new Node[oldTable.length * 2];
        table = newTable;
        for (Node<K, V> node : oldTable) {
            Node<K, V> temp;
            if (node != null) {
                temp = node;
                newTable[indexOfBucket(temp.key)] = temp;
            }
        }
        return table;
    }

    private int hash(K key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    private int indexOfBucket(K key) {
        return hash(key) & (table.length - 1);
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                while (point < table.length) {
                    if (table[point] != null) {
                        rsl = true;
                        break;
                    }
                    point++;
                }
                return rsl;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[point++].value;
            }
        };
    }

    private class Node<K, V> {
        private int hash;
        private K key;
        private V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
