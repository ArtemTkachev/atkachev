package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray ra = new RotateArray();
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] resultArray = ra.rotate(array);
        int[][] expectArray = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray ra = new RotateArray();
        int[][] array = new int[][]{{1, 2}, {3, 4}};
        int[][] resultArray = ra.rotate(array);
        int[][] expectArray = new int[][]{{3, 1}, {4, 2}};
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void whenRotateFourRowFourColArrayThenRotatedArray() {
        RotateArray ra = new RotateArray();
        int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] resultArray = ra.rotate(array);
        int[][] expectArray = new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertThat(resultArray, is(expectArray));
    }

}
