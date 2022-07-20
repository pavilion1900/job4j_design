package ru.job4j.ood.tdd.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqMaxTest {

    @Test
    public void whenFindMax() {
        SqMax sqMax = new SqMax();
        int actual = sqMax.max(10, 5, 58, 9);
        assertThat(actual, is(58));
    }

    @Test
    public void whenFindMax2() {
        SqMax sqMax = new SqMax();
        int actual = sqMax.max(5, 10, 58, 9);
        assertThat(actual, is(58));
    }

    @Test
    public void whenFindMax3() {
        SqMax sqMax = new SqMax();
        int actual = sqMax.max(58, 5, 10, 9);
        assertThat(actual, is(58));
    }

    @Test
    public void whenFindMax4() {
        SqMax sqMax = new SqMax();
        int actual = sqMax.max(9, 5, 58, 10);
        assertThat(actual, is(58));
    }
}