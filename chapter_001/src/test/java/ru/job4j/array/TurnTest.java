package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = new int[]{1,2,3,4,5};
        int[] resultArray = turn.back(array);
        int[] expectArray = new int[]{5,4,3,2,1};
        assertThat(resultArray,is(expectArray));
    }

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = new int[]{4,1,6,2};
        int[] resultArray = turn.back(array);
        int[] expectArray = new int[]{2,6,1,4};
        assertThat(resultArray,is(expectArray));
    }


}
