package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        BubbleSort bs = new BubbleSort();
        int[] array = new int[]{5,1,2,7,3};
        int[] resultArray = bs.sort(array);
        int[] expectArray = new int[]{1,2,3,5,7};
        assertThat(resultArray,is(expectArray));
    }

}
