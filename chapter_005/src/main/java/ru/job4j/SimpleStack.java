package ru.job4j;

import java.util.NoSuchElementException;

public class SimpleStack<E> extends StackQueueContainer<E> {
    public SimpleStack() {
        super();
    }
    @Override
    public E poll() {
        if (simpleLinkList.getSize() > 0) {
            return simpleLinkList.remove(0);
        } else
            throw new NoSuchElementException();
    }


}
