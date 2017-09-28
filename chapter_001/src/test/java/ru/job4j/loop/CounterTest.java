package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void SumOfEvenNumbers() {
        Counter cnt = new Counter();
        int res = cnt.add(1, 10);
        assertThat(res, is(30));

    }
}
