package ru.job4j;

public interface SetContainer<T> extends Iterable<T> {
    void add(T t);
}
