package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleListTest {

    private SimpleList<String> stringSimpleList;

    @Before
    public void setUp() {
        stringSimpleList = new SimpleList<>();
    }

    @Test
    public void whenAddElToSLThenSlHaveEl() {
        stringSimpleList.add("Николай");
        String res = stringSimpleList.get(0);
        assertThat(res,is("Николай"));
    }

    @Test
    public void whenGetElFromSLThenReturnWhisEl() {
        stringSimpleList.add("Николай");
        String res = stringSimpleList.get(0);
        assertThat(res,is("Николай"));
    }

    @Test
    public void whenAddMore10ElToSLThenSlGrowUp() {
        stringSimpleList.add("Николай");
        stringSimpleList.add("Петр");
        stringSimpleList.add("Иван");
        stringSimpleList.add("Антон");
        stringSimpleList.add("Борис");
        stringSimpleList.add("Влад");
        stringSimpleList.add("Игнат");
        stringSimpleList.add("Михей");
        stringSimpleList.add("Артем");
        stringSimpleList.add("Игорь");
        stringSimpleList.add("Джонни");
        String res = stringSimpleList.get(10);
        assertThat(res,is("Джонни"));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation () {
        stringSimpleList.add("Николай");
        stringSimpleList.add("Петр");
        stringSimpleList.add("Иван");
        Iterator<String> it = stringSimpleList.iterator();
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
