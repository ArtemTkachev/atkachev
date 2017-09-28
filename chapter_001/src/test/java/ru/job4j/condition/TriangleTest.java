package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;


public class TriangleTest {

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0,0);
        Point b = new Point(0,2);
        Point c = new Point(2,0);

        Triangle trn = new Triangle(a, b, c);
        double rsl = trn.area();
        System.out.println(rsl);
        double expected = 2D;
        assertThat(rsl, closeTo(expected,0.1));
    }


}
