package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;

    public T poll() {
        if (in == null) {
            throw new NoSuchElementException();
        }
        countOut = countIn;
        while (countOut > 0) {
            out.push(in.pop());
            countOut--;
        }
        T deleted = out.pop();
        while (countIn - 1 > 0) {
            in.push(out.pop());
            countIn--;
            countOut++;
        }
        countIn = countOut;
        return deleted;
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }
}