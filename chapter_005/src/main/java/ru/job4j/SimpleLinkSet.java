package ru.job4j;

import java.util.Iterator;

public class SimpleLinkSet<T> implements SetContainer<T> {
    private final SimpleLinkList<T> simpleLinkList = new SimpleLinkList<>();

    @Override
    public void add(T t) {
        boolean flag = false;
        Iterator<T> iterator = simpleLinkList.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(t)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            simpleLinkList.add(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleLinkList.iterator();
    }
}
