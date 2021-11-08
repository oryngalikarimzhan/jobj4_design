package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = column < data[row].length;
        int r = row;
        while (!rsl && r < data.length) {
            rsl = column < data[r++].length;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (data[row].length == 0 || column == data[row].length) {
            row++;
            column = 0;
        }
        return data[row].length > 1 ? data[row][column++] : data[row++][column];
    }
}
