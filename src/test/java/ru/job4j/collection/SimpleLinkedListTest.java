package ru.job4j.collection;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Test
    public void whenAddThenGet() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.add("Sunday");
        strings.add("Monday");
        assertThat(strings.get(1), is("Monday"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.add("Sunday");
        strings.add("Monday");
        String rsl = strings.iterator().next();
        assertThat(rsl, is("Sunday"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.add("Sunday");
        strings.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.add("Sunday");
        Iterator<String> it = strings.iterator();
        strings.add("Monday");
        it.next();
    }

    @Test
    public void whenAddThenItTwoNext() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.add("Sunday");
        strings.add("Monday");
        Iterator<String> it = strings.iterator();
        assertThat(it.next(), is("Sunday"));
        assertThat(it.next(), is("Monday"));
    }
}