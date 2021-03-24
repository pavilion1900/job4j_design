package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User first = new User("Max", 1, new GregorianCalendar(1988, Calendar.JUNE, 20));
        User second = new User("Max", 1, new GregorianCalendar(1988, Calendar.JUNE, 20));
        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println(map);
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        System.out.println(first.hashCode() & 15);
        System.out.println(second.hashCode() & 15);
    }
}
