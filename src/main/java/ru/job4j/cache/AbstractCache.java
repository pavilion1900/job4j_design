package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.*;

public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            put(key, load(key));
        }
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value == null) {
            value = load(key);
            put(key, value);
        }
        return value;
    }

    public abstract V load(K key);
}
