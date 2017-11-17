package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            private Iterator<Integer> in;

            private boolean nextVal() {
                while (true) {
                    if (in != null && in.hasNext()) {
                        return true;
                    } else {
                        if (it.hasNext()) {
                            in = it.next();
                        } else {
                            return false;
                        }
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return nextVal();
            }

            @Override
            public Integer next() {
                if (nextVal()) {
                    return in.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
