package ru.job4j;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArraysSortTest {
    @Test
    public void whenThreeArraysToSetThenSortAscSet() {
        ArraysSort arraysSort = new ArraysSort();
        ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>(Arrays.asList(new Integer[] {1,2,3},new Integer[] {1,2,0},new Integer[] {1,2,1}));
        Set<ComparedList> resSet = arraysSort.sortAsc(arrayList);
        ArrayList<Integer[]> arrayListexc = new ArrayList<Integer[]>(Arrays.asList(new Integer[] {1,2,0},new Integer[] {1,2,1},new Integer[] {1,2,3}));
        int count = 0;
        for (ComparedList comparedList: resSet) {
            assertThat(comparedList,is(new ComparedList(new ArrayList<Integer>(Arrays.asList(arrayListexc.get(count++))))));
        }
    }
    @Test
    public void whenThreeArraysToSetThenSortDescSet() {
        ArraysSort arraysSort = new ArraysSort();
        ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>(Arrays.asList(new Integer[] {1,2,3},new Integer[] {1,2,0},new Integer[] {1,2,1}));
        Set<ComparedList> resSet = arraysSort.sortDesc(arrayList);
        ArrayList<Integer[]> arrayListexc = new ArrayList<Integer[]>(Arrays.asList(new Integer[] {1,2,3},new Integer[] {1,2,1},new Integer[] {1,2,0}));
        int count = 0;
        for (ComparedList comparedList: resSet) {
            assertThat(comparedList,is(new ComparedList(new ArrayList<Integer>(Arrays.asList(arrayListexc.get(count++))))));
        }
    }

}
