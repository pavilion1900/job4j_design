package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void addElements() {
        SimpleArray<String> strings = new SimpleArray<>(5);
        strings.add("Gomel");
        strings.add("Minsk");
        String[] exp = {"Gomel", "Minsk"};
        assertThat(strings.showArray(), is(exp));
    }

    @Test
    public void setElement() {
        SimpleArray<Integer> integers = new SimpleArray<>(5);
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.set(1, 55);
        Integer[] exp = {10, 55, 30};
        assertThat(integers.showArray(), is(exp));
    }

    @Test
    public void removeElement() {
        SimpleArray<Double> doubles = new SimpleArray<>(5);
        doubles.add(10.25);
        doubles.add(20.33);
        doubles.add(30.1);
        doubles.remove(1);
        Double[] exp = {10.25, 30.1};
        assertThat(doubles.showArray(), is(exp));
    }

    @Test
    public void getElement() {
        SimpleArray<Integer> integers = new SimpleArray<>(5);
        integers.add(10);
        integers.add(20);
        integers.add(30);
        assertThat(integers.get(1), is(20));
    }

}