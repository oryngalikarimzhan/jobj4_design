package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {
    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            grow();
        }
            container[size] = value;
            size++;
            modCount++;
    }

    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public T set(int index, T newValue) {
        if (size == container.length) {
            grow();
        }
        System.arraycopy(container, Objects.checkIndex(index, size),
                container, index + 1, size - index);
        T replaced = container[index];
        container[index] = newValue;
        modCount++;
        return replaced;
    }

    @Override
    public T remove(int index) {
        T removed = container[Objects.checkIndex(index, size)];
        System.arraycopy(container, index + 1, container, index, size - 1 - index);
        container[size] = null;
        size--;
        modCount++;
        return removed;
    }

    @Override
    public T get(int index) {
        return container[Objects.checkIndex(index, size)];
    }

    @Override
    public int size() {
        return size;
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private final int expectedModCount = modCount;
            private final int expectedSize = size;
            private int count = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < expectedSize;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}