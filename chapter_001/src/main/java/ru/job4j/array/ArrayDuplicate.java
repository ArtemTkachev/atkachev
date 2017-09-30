package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    public String[] remove(String[] array) {
        String tmp;
        int cntdupl = 0;
        for (int cnt = 0; cnt < array.length; cnt++) {
            if (cnt <= array.length - 1 - cntdupl) {
                for (int i = 0; i < array.length; i++) {
                    if (i <= array.length - 1 - cntdupl && i!=cnt) {
                        if (array[cnt].equals(array[i])) {
                            tmp = array[i];
                            array[i] = array[array.length - 1 - cntdupl];
                            array[array.length - 1 - cntdupl] = tmp;
                            cntdupl++;
                            i--;
                        }
                    }
                }
            }
        }
        return Arrays.copyOf(array, array.length - cntdupl);
    }
}
