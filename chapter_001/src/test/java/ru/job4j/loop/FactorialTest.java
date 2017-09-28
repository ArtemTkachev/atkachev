package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void whenFactorialForFiveThenOneHundreedTwenty() {
        Factorial fct = new Factorial();
        int rslt = fct.calc(5);
        assertThat(rslt, is(120));
    }

    @Test
    public void whenFactorialForZeroThenOne() {
        Factorial fct = new Factorial();
        int rslt = fct.calc(0);
        assertThat(rslt, is(1));
    }
}
