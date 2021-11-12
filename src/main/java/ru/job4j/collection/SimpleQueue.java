package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;

    public T poll() {
        countOut = countIn;
        while (countOut > 0) {
            out.push(in.pop());
            countOut--;
        }
        T delete = out.pop();
        while (countIn - 1 > 0) {
            in.push(out.pop());
            countIn--;
            countOut++;
        }
        countIn = countOut;
        return delete;
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }
}