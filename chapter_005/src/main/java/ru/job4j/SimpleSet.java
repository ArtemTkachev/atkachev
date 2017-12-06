package ru.job4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements SetContainer<T> {
    private Object[] container = new Object[10];
    private int num = 0;

    public Object[] getContainer() {
        return container;
    }

    public int getSize() {
        return num;
    }

    @Override
    public void add(T t) {
        boolean haveEl = false;
        if (num > 0)
            for (int z = 0; z < num; z++) {
                if (container[z].equals(t)) {
                    haveEl = true;
                    break;
                }
            }
        if (!haveEl) {
            if (num >= container.length) {
                arrayUp();
            }
            container[num++] = t;
        }
    }

    private void arrayUp() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    private boolean correctIndex(int pos) {
        return 0 <= pos && pos < num;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int itNum = 0;

            @Override
            public boolean hasNext() {
                return correctIndex(itNum);
            }

            @Override
            public T next() {
                if (correctIndex(itNum)) {
                    return (T) container[itNum++];
                } else
                    throw new NoSuchElementException();
            }
        };
    }
}
