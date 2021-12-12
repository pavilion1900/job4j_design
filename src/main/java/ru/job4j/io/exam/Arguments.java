package ru.job4j.io.exam;

import java.util.*;

public class Arguments {
    private Map<String, String> map = new HashMap<>();

    public String getValue(String key) {
        if (key == null) {
            throw new UnsupportedOperationException();
        }
        return map.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String elem : args) {
            String[] array = elem.split("=");
            if (array.length == 1 || array.length > 3) {
                throw new IllegalArgumentException();
            }
            map.put(array[0].substring(1), array[1]);
        }
    }

    public static ru.job4j.io.exam.Arguments of(String[] args) {
        ru.job4j.io.exam.Arguments arguments = new ru.job4j.io.exam.Arguments();
        arguments.parse(args);
        return arguments;
    }
}
