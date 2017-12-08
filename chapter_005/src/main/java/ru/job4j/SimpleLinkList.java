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

        Element(E item, Element<E> next, Element<E> prev) {
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


    public int getSize() {
        return size;
    }

    public E remove(int index) {
        if (correctIndex(index)) {
            Element<E> findElement = getEl(index);
            if (index != size - 1) {
                findElement.next.prev = findElement.prev;
            } else {
                last = findElement.prev;
            }
            if (index != 0) {
                findElement.prev.next = findElement.next;
            } else {
                first = findElement.next;
            }
            E retVal = findElement.item;
            findElement = null;
            size--;
            return retVal;
        } else
            throw new NoSuchElementException();
    }

    public void set(int index, E e) {
        if (correctIndex(index)) {
            getEl(index).item = e;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public E get(int index) {
        if (correctIndex(index)) {
            return getEl(index).item;
        } else
            throw new NoSuchElementException();
    }

    public boolean contains(E e) {
        boolean res = false;
        if (size > 0) {
            Element<E> el = first;
            while (el != null) {
                if (el.item.equals(e)) {
                    res = true;
                    break;
                }
                el = el.next;
            }
        }
        return res;
    }

    private Element<E> getSingle(int index) {
        Element<E> returnElement = null;
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
                returnElement = el;
            }
            el = crmnt == 1 ? el.next : el.prev;
        } while (pos != index);
        return returnElement;
    }


    private Element<E> getEl(int index) {
        Element<E> returnEl = null;
        switch (size) {
            case 1:
                returnEl = first;
                break;
            case 2:
                returnEl = index == 0 ? first : last;
                break;
            default:
                returnEl = getSingle(index);
                break;
        }
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
                } else
                    throw new NoSuchElementException();
            }
        };
    }

}
