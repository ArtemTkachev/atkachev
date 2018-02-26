package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class SimpleLinkList<E> implements ListContainer<E> {
    @GuardedBy("this")
    private int size = 0;
    @GuardedBy("this")
    private Element<E> first;
    @GuardedBy("this")
    private Element<E> last;
    @GuardedBy("this")
    private int modCount = 0;

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
    public synchronized void add(E e) {
        Element<E> pl = new Element<E>(e, null, size > 0 ? last : null);
        if (size > 0)
            last.next = pl;
        last = pl;
        if (size == 0)
            first = pl;
        size++;
        modCount++;
    }

    private synchronized boolean correctIndex(int pos) {
        return 0 <= pos && pos < size;
    }


    public synchronized int getSize() {
        return size;
    }

    public synchronized E remove(int index) {
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
            modCount++;
            return retVal;
        } else
            throw new NoSuchElementException();
    }

    public synchronized void set(int index, E e) {
        if (correctIndex(index)) {
            getEl(index).item = e;
            modCount++;
        } else
            throw new NoSuchElementException();
    }

    @Override
    public synchronized E get(int index) {
        if (correctIndex(index)) {
            return getEl(index).item;
        } else
            throw new NoSuchElementException();
    }

    public synchronized boolean contains(E e) {
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

    private synchronized Element<E> getSingle(int index) {
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


    private synchronized Element<E> getEl(int index) {
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
    public synchronized Iterator<E> iterator() {
        return new Iterator<E>() {
            @GuardedBy("this")
            private int itIndex = 0;
            @GuardedBy("this")
            private int expectedModCount = modCount;
            @GuardedBy("this")
            Element<E> el = first;
            @GuardedBy("this")
            Element<E> retEl;

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
                    if (correctIndex(itIndex)) {
                        retEl = el;
                        el = el.next;
                        itIndex++;
                        return retEl.item;
                    } else
                        throw new NoSuchElementException();
                } else
                    throw new ConcurrentModificationException();
            }
        };
    }

}
