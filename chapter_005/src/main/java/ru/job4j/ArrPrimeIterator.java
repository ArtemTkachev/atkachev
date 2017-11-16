package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrPrimeIterator implements Iterator {
    private final int[] values;
    private int inxin = 0;

    public ArrPrimeIterator(final int[] values) {
        this.values = values;
    }

    public int nextIndex() {
        int indx = inxin;
        while (indx < values.length) {
            if (values[indx] > 1) {
                int max = (int) Math.floor(values[indx] / 2);
                int limit = max > 2 ? max : 2;
                for (int i = 2; i <= limit; i++) {
                    if (values[indx] % i == 0 && values[indx]!=i) {
                        break;
                    }
                    if (i == limit) {
                        return indx;
                    }
                }
            }
            indx++;
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
