package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleHashSet<E> {
    private Object[] container = new Object[100];

    private int hash(E e) {
        return Math.abs(e.hashCode() % container.length);
    }

    public boolean add(E e) {
        boolean result = false;
        if (!contains(e)) {
            int hashV = hash(e);
            while (hashV >= container.length) {
                arrayUp();
            }
            container[hashV] = e;
            result = true;
        }
        return result;
    }

    private void arrayUp() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    public boolean contains(E e) {
        boolean result = false;
        int hashV = hash(e);
        if (hashV < container.length) {
            if (container[hashV] != null && container[hashV].equals(e)) {
                result = true;
            }
        }
        return result;
    }

    public boolean remove(E e) {
        boolean result = false;
        if (contains(e)) {
            container[hash(e)] = null;
            result = true;
        }
        return result;
    }

}
