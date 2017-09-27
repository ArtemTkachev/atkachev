package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maximum = new Max();
        int res = maximum.max(2,3);
        assertThat(res,is(3));

    }
}
