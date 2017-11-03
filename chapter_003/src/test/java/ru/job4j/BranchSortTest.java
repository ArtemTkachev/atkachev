package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BranchSortTest {
    @Test
    public void whenSortArrayListAscThenTrueSort() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK2","K2\\SK1\\SSK1", "K1\\SK2\\SSK1"));
        ArrayList<String> result = new BranchSort().sorted(list, true);
        ArrayList<String> except = new ArrayList<String>(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K1\\SK2","K1\\SK2\\SSK1", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        assertThat(result,is(except));
    }
    @Test
    public void whenSortArrayListDescThenTrueSort() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK2","K2\\SK1\\SSK1", "K1\\SK2\\SSK1"));
        ArrayList<String> result = new BranchSort().sorted(list, false);
        ArrayList<String> except = new ArrayList<String>(Arrays.asList("K2","K2\\SK1","K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1",
                "K1\\SK2","K1\\SK2\\SSK1", "K1\\SK1",  "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"));
        assertThat(result,is(except));
    }
}
