package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    @Test
    public void addUser() {
        User first = new User("Nick");
        User second = new User("Sergey");
        User third = new User("Max");
        Store<User> store = new MemStore<>();
        store.add(first);
        store.add(second);
        store.add(third);
        assertThat(store.findById("Max"), is(third));
    }

    @Test
    public void replaceUser() {
        User first = new User("Nick");
        User second = new User("Sergey");
        User third = new User("Max");
        User forth = new User("Pasha");
        Store<User> store = new MemStore<>();
        store.add(first);
        store.add(second);
        store.add(third);
        assertTrue(store.replace("Max", forth));
    }

    @Test
    public void deleteUser() {
        User first = new User("Nick");
        User second = new User("Sergey");
        User third = new User("Max");
        Store<User> store = new MemStore<>();
        store.add(first);
        store.add(second);
        store.add(third);
        assertTrue(store.delete("Max"));
    }

}