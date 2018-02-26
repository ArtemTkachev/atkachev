package ru.job4j;

public interface ListContainer<E> extends Iterable<E> {
    void add(E e);
    E get(int index);

}
