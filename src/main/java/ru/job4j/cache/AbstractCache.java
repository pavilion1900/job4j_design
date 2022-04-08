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
            load(key);
        }
        V value = cache.get(key).get();
        return value;
    }

    public abstract V load(K key);
}
