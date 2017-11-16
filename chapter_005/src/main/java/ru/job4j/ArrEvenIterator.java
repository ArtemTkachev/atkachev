package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrEvenIterator implements Iterator {
    private final int[] values;
    private int inxin = 0;


    public ArrEvenIterator(final int[] values) {
        this.values = values;
    }

    public int nextIndex() {
        int indx = inxin;
        while (indx < values.length) {
            if (values[indx] % 2 == 0) {
                return indx;
            } else {
                indx++;
            }
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return this.nextIndex() != -1;
    }

    @Override
    public Object next() {
        int indx = this.nextIndex();
        if (indx != -1) {
            inxin = indx;
            return values[inxin++];
        } else {
            throw new NoSuchElementException();
        }
    }
}