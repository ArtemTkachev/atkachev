package ru.job4j;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
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
            List<Integer> resList = Arrays.asList(1, 2, 3, null, 5, 6, 7);
            int[][] resar = cl.toArray(resList, 3);
            int[][] exceptarr = new int[][] {{1,2,3},{0,5,6},{7,0,0}};
            assertThat(resar, is(exceptarr));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void whenListofArraysConvertToListThenList() {
        ConvertList cl = new ConvertList();
        List<int[]> list = new ArrayList<int[]>();
        list.add(new int[] {1,2});
        list.add(new int[] {4,5,6});
        list.add(new int[] {7,8,9});
        list.add(null);
        List<Integer> result = cl.convert(list);
        List<Integer> excepted = Arrays.asList(1,2,4,5,6,7,8,9);
        assertThat(result,is(excepted));
    }
}
