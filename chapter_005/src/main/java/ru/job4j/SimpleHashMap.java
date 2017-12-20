package ru.job4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements SimpleMapContainer<K, V> {
    private Object[] container = new Object[12];
    private int count = 0;


    private class Ent<K, V> {
        private K key;
        private V value;
        private int hash;

        public Ent(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    @Override
    public boolean insert(K key, V value) {
        boolean result = false;
        if (key != null) {
            int hcode = hash(key.hashCode());
            int index = indexFor(hcode, container.length);
            int cntns = contains(key, index);
            if (cntns == 1) {
                changeOldKey(index, value);
                result = true;
            } else if (cntns == -1) {
                if (0.5 * container.length <= count) {
                    int oldLen = container.length;
                    arrayUp();
                    transfer(oldLen);
                    index = indexFor(hash(key.hashCode()), container.length);
                    cntns = contains(key, index);
                    if(cntns == -1) {
                        createNewKey(index, key, value, hcode);
                    }
                } else {
                    createNewKey(index, key, value, hcode);
                }
                result = true;
            }
        }
        return result;
    }

    private void changeOldKey(int indx, V value) {
        Ent<K, V> ent = (Ent<K, V>) container[indx];
        ent.value = value;
    }

    private void createNewKey(int indx, K key, V value, int hash) {
        container[indx] = new Ent<>(key, value, hash);
        count++;
    }

    private void transfer(int oldLen) {
        Object[] containerTemp = new Object[container.length];
        for (int i = 0; i < oldLen; i++) {
            if (container[i] != null) {
                Ent<K, V> ent = (Ent<K, V>) container[i];
                int index = indexFor(ent.hash, container.length);
                if (containerTemp[index]!=null)
                    count--;
                containerTemp[index] = ent;
            }
        }
        container = Arrays.copyOf(containerTemp, containerTemp.length);
    }


    private void arrayUp() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    private int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    @Override
    public V get(K key) {
        V result = null;
        if (key != null) {
            int index = indexFor(hash(key.hashCode()), container.length);
            if (contains(key, index) == 1) {
                Ent<K, V> ent = (Ent<K, V>) container[index];
                result = ent.value;
            }
        }
        return result;
    }

    private int contains(K key, int indx) {
        int result = -1;
        int index = indx != -1 ? indx : indexFor(hash(key.hashCode()), container.length);
        if (index < container.length) {
            if (container[index] != null) {
                Ent<K, V> ent = (Ent<K, V>) container[index];
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
        if (key != null) {
            int index = indexFor(hash(key.hashCode()), container.length);
            if (contains(key, index) == 1) {
                container[index] = null;
                count--;
                result = true;
            }
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
