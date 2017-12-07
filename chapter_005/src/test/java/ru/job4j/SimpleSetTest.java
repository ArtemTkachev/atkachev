package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleSetTest {
    private SimpleSet<String> stringSimpleSet;

    @Before
    public void setUp() {
        stringSimpleSet = new SimpleSet<>();
    }

    @Test
    public void whenAddElToSsThenSsHaveEl() {
        stringSimpleSet.add("Николай");
        assertThat(stringSimpleSet.getContainer()[0], is("Николай"));
    }

    @Test
    public void whenAddElDblToSsThenSsHaveOldEl() {
        stringSimpleSet.add("Николай");
        stringSimpleSet.add("Петр");
        stringSimpleSet.add("Иван");
        stringSimpleSet.add("Петр");
        assertThat(stringSimpleSet.getSize(), is(3));
    }


    @Test
    public void whenAddMore10ElToSsThenSsGrowUp() {
        stringSimpleSet.add("Николай");
        stringSimpleSet.add("Петр");
        stringSimpleSet.add("Иван");
        stringSimpleSet.add("Антон");
        stringSimpleSet.add("Борис");
        stringSimpleSet.add("Влад");
        stringSimpleSet.add("Игнат");
        stringSimpleSet.add("Михей");
        stringSimpleSet.add("Артем");
        stringSimpleSet.add("Игорь");
        stringSimpleSet.add("Джонни");
        assertThat(stringSimpleSet.getContainer()[10], is("Джонни"));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        stringSimpleSet.add("Николай");
        stringSimpleSet.add("Петр");
        stringSimpleSet.add("Иван");
        Iterator<String> it = stringSimpleSet.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Николай"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Петр"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Иван"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

}
