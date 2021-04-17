package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenAdd() {
        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(10, "Sergey"));
        previous.add(new Analize.User(20, "Max"));
        previous.add(new Analize.User(30, "Nick"));
        List<Analize.User> current = new ArrayList<>(previous);
        current.add(new Analize.User(40, "Pasha"));
        current.add(new Analize.User(50, "Alex"));
        Analize analize = new Analize();
        Analize.Info rsl = analize.diff(previous, current);
        Analize.Info exp = new Analize.Info(2, 0, 0);
        assertThat(exp, is(rsl));
    }

    @Test
    public void whenDelete() {
        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(10, "Sergey"));
        previous.add(new Analize.User(20, "Max"));
        previous.add(new Analize.User(30, "Nick"));
        List<Analize.User> current = new ArrayList<>(previous);
        current.remove(1);
        Analize analize = new Analize();
        Analize.Info rsl = analize.diff(previous, current);
        Analize.Info exp = new Analize.Info(0, 0, 1);
        assertThat(exp, is(rsl));
    }

    @Test
    public void whenChange() {
        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(10, "Sergey"));
        previous.add(new Analize.User(20, "Max"));
        previous.add(new Analize.User(30, "Nick"));
        List<Analize.User> current = new ArrayList<>(previous);
        current.set(1, new Analize.User(20, "Maximus"));
        Analize analize = new Analize();
        Analize.Info rsl = analize.diff(previous, current);
        Analize.Info exp = new Analize.Info(0, 1, 0);
        assertThat(exp, is(rsl));
    }

    @Test
    public void whenMix() {
        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(10, "Sergey"));
        previous.add(new Analize.User(20, "Max"));
        previous.add(new Analize.User(30, "Nick"));
        List<Analize.User> current = new ArrayList<>(previous);
        current.add(new Analize.User(40, "Pasha"));
        current.remove(1);
        current.set(0, new Analize.User(10, "Denis"));
        Analize analize = new Analize();
        Analize.Info rsl = analize.diff(previous, current);
        Analize.Info exp = new Analize.Info(1, 1, 1);
        assertThat(exp, is(rsl));
    }
}