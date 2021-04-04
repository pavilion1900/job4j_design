package ru.job4j.collection.map;

import org.junit.Test;
import ru.job4j.collection.set.Set;
import ru.job4j.collection.set.SimpleSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    @Test
    public void whenInsert() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(236945971, "Gomel");
        map.insert(13597465, "Brest");
        assertThat(map.get(236945971), is("Gomel"));
        assertThat(map.get(13597465), is("Brest"));
    }

    @Test
    public void whenGetIteratorTwice() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(236945971, "Gomel");
        map.insert(13597465, "Brest");
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Gomel"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Brest"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        Iterator<String> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(236945971, "Gomel");
        Iterator<String> it = map.iterator();
        map.insert(13597465, "Brest");
        it.next();
    }

    @Test
    public void whenDelete() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(236945971, "Gomel");
        map.insert(13597465, "Brest");
        assertTrue(map.delete(236945971));
        assertTrue(map.delete(13597465));
    }
}