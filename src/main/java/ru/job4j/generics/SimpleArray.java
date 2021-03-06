package ru.job4j.generics;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private final Object[] array;
    private int size = 0;

    public SimpleArray(int row) {
        this.array = (T[]) new Object[row];
    }

    public void add(T model) {
        array[size++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        array[index] = null;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size - 1] = null;
        size--;
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[point++];
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleArray{" + "array=" + Arrays.toString(array) + '}';
    }

    public <T> T[] showArray() {
        return (T[]) Arrays.copyOf(array, size);
    }
}
