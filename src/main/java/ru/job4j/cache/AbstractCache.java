package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        SoftReference<V> tempDate = cache.get(key);
        if (!cache.containsKey(key) || tempDate == null) {
            System.out.println("---File was loaded to cache---");
            load(key);
        } else {
            System.out.println("---File was already loaded to cache---");
        }
        System.out.println("---Getting from cache---");
        return cache.get(key).get();
    }

    protected abstract V load(K key);
}