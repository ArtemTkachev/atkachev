package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    Max maximum = new Max();
    @Test
    public void whenFirstLessSecond() {
        int res = maximum.max(2,3);
        assertThat(res,is(3));

    }

    @Test
    public void whenFirstLessSecondLessThird() {
        int res = maximum.maxthreeparam(1,2,5);
        assertThat(res,is(5));

    }
}
