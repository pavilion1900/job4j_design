package ru.job4j.collection.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenGetIteratorTwice() {
        Set<Integer> set = new SimpleSet<>();
        set.add(10);
        set.add(20);
        Iterator<Integer> it = set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(20));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        Set<Integer> set = new SimpleSet<>();
        Iterator<Integer> it = set.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Set<Integer> set = new SimpleSet<>();
        set.add(10);
        Iterator<Integer> it = set.iterator();
        set.add(20);
        it.next();
    }
}