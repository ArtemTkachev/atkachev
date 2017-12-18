package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements SimpleMapContainer<K, V> {
    private Object[] container = new Object[10];


    private class Ent<K, V> {
        private K key;
        private V value;

        public Ent(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public boolean insert(K key, V value) {
        boolean result = false;
        int hashV = hash(key);
        int cnrns = contains(key, hashV);
        if (cnrns == 1) {
            Ent<K, V> ent = (Ent<K, V>) container[hashV];
            ent.value = value;
            result = true;
        } else if (cnrns == -1) {
            while (hashV >= container.length) {
                arrayUp();
            }
            container[hashV] = new Ent<>(key, value);
            result = true;
        }
        return result;
    }

    private void arrayUp() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % container.length);
    }

    @Override
    public V get(K key) {
        V result = null;
        int hashV = hash(key);
        if (contains(key, hashV) == 1) {
            Ent<K, V> ent = (Ent<K, V>) container[hashV];
            result = ent.value;
        }
        return result;
    }

    private int contains(K key, int hashVal) {
        int result = -1;
        int hashV = hashVal != -1 ? hashVal : hash(key);
        if (hashV < container.length) {
            if (container[hashV] != null) {
                Ent<K, V> ent = (Ent<K, V>) container[hashV];
                if (ent.key.equals(key)) {
                    result = 1;
                } else {
                    result = 0;
                }
            }
        }
        return result;
    }

    @Override
    public boolean delete(K key) {
        boolean result = false;
        int hashV = hash(key);
        if (contains(key, hashV) == 1) {
            container[hashV] = null;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index = -1;

            private K hasEl(String func) {
                K result = null;
                if (index + 1 < container.length) {
                    for (int i = index + 1; i < container.length; i++) {
                        if (container[i] != null) {
                            Ent<K, V> ent = (Ent<K, V>) container[i];
                            result = ent.key;
                            if (func == "n")
                                index = i;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public boolean hasNext() {
                return hasEl("hN") != null;
            }

            @Override
            public K next() {
                K key = hasEl("n");
                if (key != null) {
                    return key;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
