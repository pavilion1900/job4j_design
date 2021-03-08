package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;
    private int modCount = 0;

    public void add(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private Node<E> temp = first;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E rsl = temp.item;
                temp = temp.next;
                return rsl;
            }
        };
    }

    private static class Node<E> {
        private Node<E> prev;
        private E item;
        private Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
