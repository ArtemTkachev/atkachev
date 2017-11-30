package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkList<E> implements ListContainer<E> {

    private int size = 0;
    private Element<E> first;
    private Element<E> last;

    public SimpleLinkList() {
    }

    private static class Element<E> {
        E item;
        Element<E> next;
        Element<E> prev;

        public Element(E item, Element<E> next, Element<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(E e) {
        Element<E> pl = new Element<E>(e, null, size > 0 ? last : null);
        if (size > 0)
            last.next = pl;
        last = pl;
        if (size == 0)
            first = pl;
        size++;
    }

    private boolean correctIndex(int pos) {
        return 0 <= pos && pos < size;
    }

    private E getFirst() {
        return first.item;
    }

    private E getLast() {
        return last.item;
    }

    private E getSingle(int index) {
        E returnElement = null;
        int pos;
        int crmnt;
        Element<E> el;
        if (size / 2 <= index) {
            pos = size;
            el = last;
            crmnt = -1;
        } else {
            pos = -1;
            el = first;
            crmnt = 1;
        }
        do {
            pos = pos + crmnt;
            if (pos == index) {
                returnElement = el.item;
            }
            el = crmnt == 1 ? el.next : el.prev;
        } while (pos != index);
        return returnElement;
    }

    @Override
    public E get(int index) {
        E returnEl = null;
        if (correctIndex(index)) {
            switch (size) {
                case 1:
                    returnEl = getFirst();
                    break;
                case 2:
                    returnEl = index == 0 ? getFirst() : getLast();
                    break;
                default:
                    returnEl = getSingle(index);
                    break;
            }
        } else
            throw new NoSuchElementException();
        return returnEl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int itIndex = 0;
            Element<E> el = first;
            Element<E> retEl;
            @Override
            public boolean hasNext() {
                return correctIndex(itIndex);
            }

            @Override
            public E next() {
                if (correctIndex(itIndex)) {
                    retEl = el;
                    el = el.next;
                    itIndex++;
                    return retEl.item;
                }
                else
                    throw new NoSuchElementException();
            }
        };
    }

}
