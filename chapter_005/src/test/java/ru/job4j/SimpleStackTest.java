package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleStackTest {
    private SimpleStack<String> stringSimpleStack;

    @Before
    public void setUp() {
        stringSimpleStack = new SimpleStack<>();
    }

    @Test
    public void whenPushToStackThenHaveElsAndPollFirst() {
        stringSimpleStack.push("Борис");
        stringSimpleStack.push("Иван");
        stringSimpleStack.push("Глеб");
        stringSimpleStack.push("Василий");
        String polledVal = stringSimpleStack.poll();
        assertThat(polledVal,is("Василий"));
    }
}
