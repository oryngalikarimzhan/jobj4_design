package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = parityCheck(index) && index < data.length;
        while (data[index] % 2 == 1 && data.length - 1 > index) {
            index++;
            rsl = parityCheck(index);
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    private boolean parityCheck(int index) {
        return data[index] % 2 == 0;
    }

}