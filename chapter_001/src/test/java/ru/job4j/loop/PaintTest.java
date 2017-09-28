package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint pnt = new Paint();
        String res = pnt.piramid(2);
        String line = System.getProperty("line.separator");
        String expected = String.format(" ^ %s^^^%s", line, line);
        assertThat(res, is(expected));
    }

    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint pnt = new Paint();
        String res = pnt.piramid(3);
        String line = System.getProperty("line.separator");
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", line, line, line);
        assertThat(res, is(expected));
    }

}
