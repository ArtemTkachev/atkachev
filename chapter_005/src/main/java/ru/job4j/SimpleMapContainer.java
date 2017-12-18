package ru.job4j;

public interface SimpleMapContainer<K,V> extends Iterable<K> {
    boolean insert(K key, V value);
    V get(K key);
    boolean delete(K key);
}
