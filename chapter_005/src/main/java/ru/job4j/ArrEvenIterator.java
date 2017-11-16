package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrEvenIterator implements Iterator {
    private final int[] values;
    private int inxin = 0;


    public ArrEvenIterator(final int[] values) {
        this.values = values;
    }

    public boolean hasValue() {
        while (inxin < values.length) {
            if (values[inxin] % 2 == 0) {
                return true;
            } else {
                inxin++;
            }
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return hasValue();
    }

    @Override
    public Object next() {
        if (hasValue()) {
            return values[inxin++];
        } else {
            throw new NoSuchElementException();
        }
    }
}