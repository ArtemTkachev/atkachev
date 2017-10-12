package ru.job4j.PaintTask;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    @Test
    public void whenPaintTriangleThenPaintSame() {
        Paint paint = new Paint();
        Shape shape = new Triangle();
        paint.draw(shape);
        String result = shape.pic();
        String expected = "  *  \n *** \n*****\n";
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintSquareThenPaintSame() {
        Paint paint = new Paint();
        Shape shape = new Square();
        paint.draw(shape);
        String result = shape.pic();
        String expected = "****\n****\n****\n****\n";
        assertThat(result, is(expected));
    }
}
