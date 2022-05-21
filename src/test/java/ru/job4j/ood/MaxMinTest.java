package ru.job4j.ood;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenFindMaxString() {
        List<String> list = List.of("city", "bill", "noise", "street");
        String result = new MaxMin().max(list, String::compareTo);
        assertThat(result, is("street"));
    }

    @Test
    public void whenFindMaxInteger() {
        List<Integer> list = List.of(100, 50, 35, 85, 2);
        Integer result = new MaxMin().max(list, Integer::compareTo);
        assertThat(result, is(100));
    }

    @Test
    public void whenFindMinString() {
        List<String> list = List.of("city", "bill", "noise", "street");
        String result = new MaxMin().min(list, String::compareTo);
        assertThat(result, is("bill"));
    }

    @Test
    public void whenFindMinInteger() {
        List<Integer> list = List.of(100, 50, 35, 85, 2);
        Integer result = new MaxMin().min(list, Integer::compareTo);
        assertThat(result, is(2));
    }
}