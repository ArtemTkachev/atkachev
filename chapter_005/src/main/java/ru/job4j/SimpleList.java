package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class SimpleList<E> implements ListContainer<E> {
    @GuardedBy("this")
    private Object[] container = new Object[10];
    @GuardedBy("this")
    private int index = 0;
    @GuardedBy("this")
    private int modCount = 0;

    public SimpleList() {
    }

    @Override
    public synchronized void add(E e) {
        if (index >= container.length) {
            arrayUp();
        }
        container[index++] = e;
        modCount++;
    }

    private synchronized void arrayUp() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    private synchronized boolean correctIndex(int pos) {
        return 0 <= pos && pos < index;
    }

    public synchronized boolean contains(E e) {
        boolean res = false;
        if (index > 0)
            for (int z = 0; z < index; z++) {
                if (container[z].equals(e)) {
                    res = true;
                    break;
                }
            }
        return res;
    }

    @Override
    public synchronized E get(int pos) {
        if (correctIndex(pos))
            return (E) container[pos];
        else
            throw new NoSuchElementException();
    }


    @Override
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            @GuardedBy("this")
            private int itIndex = 0;
            @GuardedBy("this")
            private int expectedModCount = modCount;

            @Override
            public synchronized boolean hasNext() {
                if (expectedModCount == modCount)
                    return correctIndex(itIndex);
                else
                    throw new ConcurrentModificationException();
            }

            @Override
            public synchronized E next() {
                if (expectedModCount == modCount) {
                    if (correctIndex(itIndex))
                        return (E) container[itIndex++];
                    else
                        throw new NoSuchElementException();
                } else
                    throw new ConcurrentModificationException();
            }
        };
    }
}
