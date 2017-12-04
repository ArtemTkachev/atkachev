package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CycleListTest {

    private CycleList<Integer> integerCycleList;

    @Before
    public void setUp() {
        integerCycleList = new CycleList<>();
    }

    @Test
    public void whenCreateNodesForCycleOneThenHaveCycle() {
       integerCycleList.createNodesForCycleOne();
       boolean result = integerCycleList.hasCycle(integerCycleList.getFirst());
       assertThat(result,is(true));
    }

    @Test
    public void whenCreateNodesForCycleTwoThenHaveCycle() {
        integerCycleList.createNodesForCycleTwo();
        boolean result = integerCycleList.hasCycle(integerCycleList.getFirst());
        assertThat(result,is(true));
    }

    @Test
    public void whenCreateNodesForCycleNoThenHaveNotCycle() {
        integerCycleList.createNodesForCycleNo();
        boolean result = integerCycleList.hasCycle(integerCycleList.getFirst());
        assertThat(result,is(false));
    }
}
