package ru.job4j;

import java.util.Iterator;

public class SimpleLinkSet<T> implements SetContainer<T> {
    private final SimpleLinkList<T> simpleLinkList = new SimpleLinkList<>();

    @Override
    public void add(T t) {
        if(!simpleLinkList.contains(t)) {
            simpleLinkList.add(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleLinkList.iterator();
    }
}
