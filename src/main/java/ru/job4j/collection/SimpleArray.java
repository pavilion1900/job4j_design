package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 3;
    private Object[] container;
    private int size = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    public void add(T model) {
        resizeContainer();
        container[size++] = model;
        modCount++;
    }

    private void resizeContainer() {
        if (size == container.length) {
            container = Arrays.copyOf(container, size + DEFAULT_CAPACITY);
        }
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[point++];
            }
        };
    }
}
