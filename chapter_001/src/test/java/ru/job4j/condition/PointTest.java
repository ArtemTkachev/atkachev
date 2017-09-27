package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenPointOnLineThenTrue() {
        Point a = new Point(1,1);
        boolean result = a.is(0,1);
        assertThat(result, is(true));
    }
}
