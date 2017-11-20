package ru.job4j;

import java.util.Arrays;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public T add(T value) {
        if (index < objects.length) {
            this.objects[index++] = value;
            return value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private boolean correctSet(int pos) {
        return pos >= 0 && pos < objects.length;
    }

    public T get(int pos) {
        if (correctSet(pos)) {
            return (T) this.objects[pos];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean delete(int pos) {
        if (correctSet(pos)) {
            this.objects[pos] = null;
            return true;
        } else {
            return false;
        }
    }

    public T update(T value) {
        T oldValue = null;
        for (int i = 0; i < objects.length; i++) {
            if (value.equals(objects[i])) {
                oldValue = (T) objects[i];
                this.objects[i] = value;
            }
        }
        return oldValue;
    }
}
