package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoArraysInOneTest {

    @Test
    public void whenTwoSortArraysThenOneSortArray() {
        TwoArraysInOne ta = new TwoArraysInOne();
        int[] res = ta.retArray(new int[]{1,8,9,11},new int[]{5,6,10,12,14,19});
        int[] expect = new int[]{1,5,6,8,9,10,11,12,14,19};
        assertThat(res,is(expect));
    }
}
