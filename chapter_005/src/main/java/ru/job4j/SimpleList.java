package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<E> implements ListContainer<E> {
    private Object[] container = new Object[10];
    private int index = 0;

    public SimpleList() {
    }

    @Override
    public void add(E e) {
        if (index >= container.length) {
            arrayUp();
        }
        container[index++] = e;
    }

    private void arrayUp() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    private boolean correctIndex(int pos) {
        return 0 <= pos && pos < index;
    }

    public boolean contains(E e) {
        boolean res = false;
        for(int z = 0; z<index; z++) {
            if(container[z].equals(e)) {
                res = true;
                break;
            }
        }
        return res;
    }

    @Override
    public E get(int pos) {
        if (correctIndex(pos))
            return (E) container[pos];
        else
            throw new NoSuchElementException();
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int itIndex = 0;

            @Override
            public boolean hasNext() {
                return correctIndex(itIndex);
            }

            @Override
            public E next() {
                if (correctIndex(itIndex))
                    return (E) container[itIndex++];
                else
                    throw new NoSuchElementException();
            }
        };
    }
}
