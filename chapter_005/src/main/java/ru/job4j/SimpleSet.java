package ru.job4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements SetContainer<T> {
    private final SimpleList<T> simpleList = new SimpleList<>();

    @Override
    public void add(T t) {
        boolean flag = false;
        Iterator<T> iterator = simpleList.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(t)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            simpleList.add(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleList.iterator();
    }

}

