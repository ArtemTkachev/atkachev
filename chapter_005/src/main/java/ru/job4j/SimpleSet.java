package ru.job4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements SetContainer<T> {
    private final SimpleList<T> simpleList = new SimpleList<>();


    public Object[] getContainer() {
        return simpleList.getContainer();
    }

    public int getSize() {
        return simpleList.getIndex();
    }

    @Override
    public void add(T t) {
        boolean haveEl = false;
        int size = getSize();
        Object[] cntr1 = getContainer();
        if (size > 0)
            for (int z = 0; z < size; z++) {
                if (cntr1[z].equals(t)) {
                    haveEl = true;
                    break;
                }
            }
        if (!haveEl) {
            if (size >= cntr1.length) {
                simpleList.arrayUp();
            }
            Object[] cntr2 = getContainer();
            cntr2[size] = t;
            simpleList.setContainer(cntr2);
            simpleList.setIndex(size + 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleList.iterator();
    }

}

