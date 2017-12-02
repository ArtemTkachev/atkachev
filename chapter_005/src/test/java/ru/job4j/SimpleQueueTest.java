package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleQueueTest {
    private SimpleQueue<String> stringSimpleQueue;

    @Before
    public void setUp() {
        stringSimpleQueue = new SimpleQueue<>();
    }

    @Test
    public void whenPushToQueueThenHaveElsAndPollLast() {
        stringSimpleQueue.push("Борис");
        stringSimpleQueue.push("Иван");
        stringSimpleQueue.push("Глеб");
        stringSimpleQueue.push("Василий");
        String polledVal = stringSimpleQueue.poll();
        assertThat(polledVal,is("Борис"));
    }
}
