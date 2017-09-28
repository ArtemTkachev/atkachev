package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void whenTableThreeToThreeThenStringThreeToThree() {
        Board brd = new Board();
        String res = brd.paint(3, 3);
        String line = System.getProperty("line.separator");
        String expected = String.format("X X%s X %sX X%s", line, line, line);
        assertThat(res, is(expected));
    }

    @Test
    public void whenTableFiveToFourThenStringFiveToFour() {
        Board brd = new Board();
        String res = brd.paint(5, 4);
        String line = System.getProperty("line.separator");
        String expected = String.format("X X X%s X X %sX X X%s X X %s", line, line, line, line);
        assertThat(res, is(expected));
    }


}
