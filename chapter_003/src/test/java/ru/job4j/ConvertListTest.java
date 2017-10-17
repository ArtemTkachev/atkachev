package ru.job4j;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {

    @Test
    public void whenArrayToListThenTrue() {
        ConvertList cl = new ConvertList();
        int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,0,0}};
        List<Integer> resList = cl.toList(arr);
        List<Integer> exceptList = Arrays.asList(1,2,3,4,5,6,7,0,0);
        assertThat(resList,is(exceptList));
    }

    @Test
    public void whenListToArrayThenTrue() {
        try {
            ConvertList cl = new ConvertList();
            List<Integer> resList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            int[][] resar = cl.toArray(resList, 3);
            int[][] exceptarr = new int[][] {{1,2,3},{4,5,6},{7,0,0}};
            assertThat(resar, is(exceptarr));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
