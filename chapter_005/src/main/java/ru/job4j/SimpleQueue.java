package ru.job4j;

import java.util.NoSuchElementException;

public class SimpleQueue<E> extends StackQueueContainer<E> {
    public SimpleQueue() {
        super();
    }
    @Override
    public E poll() {
        if (simpleLinkList.getSize() > 0) {
            return simpleLinkList.remove(simpleLinkList.getSize() - 1);
        } else
            throw new NoSuchElementException();
    }

}
