package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        int keyHash = hash(key.hashCode());
        int index = indexFor(keyHash);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        if (count / capacity >= LOAD_FACTOR) {
            expand();
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity = capacity * 2;
        table = Arrays.copyOf(table, capacity);
    }

    @Override
    public V get(K key) {
        for (MapEntry<K, V> bucket : table) {
            if (bucket != null && Objects.equals(bucket.key, key)) {
                return bucket.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        for (MapEntry<K, V> bucket : table) {
            if (bucket != null && Objects.equals(bucket.key, key)) {
                bucket.value = null;
                bucket.key = null;
                modCount++;
                count--;
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        List<K> keys = new ArrayList<>();
        for (MapEntry<K, V> bucket : table) {
            if (bucket != null) {
                keys.add(bucket.key);
            }
        }
        return new Iterator<K>() {

            private final int expectedModCount = modCount;
            private int counter = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return counter < keys.size();
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return keys.get(counter++);
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
