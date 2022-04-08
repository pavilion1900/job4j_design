package ru.job4j.cache;

import java.io.*;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    public String load(String key) {
        StringBuilder value = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(key))) {
            in.lines()
                    .forEach(elem -> value.append(elem + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        put(key, value.toString());
        return value.toString();
    }
}
