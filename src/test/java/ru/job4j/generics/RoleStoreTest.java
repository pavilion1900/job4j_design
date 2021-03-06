package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void addUser() {
        Role first = new Role("Nick");
        Role second = new Role("Sergey");
        Role third = new Role("Max");
        Store<Role> store = new MemStore<>();
        store.add(first);
        store.add(second);
        store.add(third);
        assertThat(store.findById("Max"), is(third));
    }

    @Test
    public void replaceUser() {
        Role first = new Role("Nick");
        Role second = new Role("Sergey");
        Role third = new Role("Max");
        Role forth = new Role("Pasha");
        Store<Role> store = new MemStore<>();
        store.add(first);
        store.add(second);
        store.add(third);
        assertTrue(store.replace("Max", forth));
    }

    @Test
    public void deleteUser() {
        Role first = new Role("Nick");
        Role second = new Role("Sergey");
        Role third = new Role("Max");
        Store<Role> store = new MemStore<>();
        store.add(first);
        store.add(second);
        store.add(third);
        assertTrue(store.delete("Max"));
    }

}