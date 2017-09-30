package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate ad = new ArrayDuplicate();
        String[] array = new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] resultArray = ad.remove(array);
        String[] expectArray = new String[]{"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }

}
