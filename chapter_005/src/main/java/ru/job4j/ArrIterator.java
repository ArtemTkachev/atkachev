package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrIterator implements Iterator {
    private final int[][] values;
    private int inxout = 0;
    private int inxin = 0;


    public ArrIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return inxin < values[inxout].length || inxout + 1 < values.length;
    }

    @Override
    public Object next() {
        if (inxin < values[inxout].length) {
            return values[inxout][inxin++];
        } else if (inxout + 1 < values.length) {
            inxin = 0;
            return values[++inxout][inxin++];
        } else {
            throw new NoSuchElementException();
        }
    }
}
