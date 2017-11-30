package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkListTest {
    private SimpleLinkList<String> stringSimpleLinkList;

    @Before
    public void setUp() {
        stringSimpleLinkList = new SimpleLinkList<>();
    }

    @Test
    public void whenAddElToSllThenSllHaveEl() {
        stringSimpleLinkList.add("Николай");
        String res = stringSimpleLinkList.get(0);
        assertThat(res, is("Николай"));
    }

    @Test
    public void whenGetElFromSllWithOneElThenReturnWhisEl() {
        stringSimpleLinkList.add("Николай");
        String res = stringSimpleLinkList.get(0);
        assertThat(res,is("Николай"));
    }

    @Test
    public void whenGetElFromSllWithTwoElThenReturnWhisEl() {
        stringSimpleLinkList.add("Николай");
        stringSimpleLinkList.add("Петр");
        String res = stringSimpleLinkList.get(1);
        assertThat(res,is("Петр"));
    }

    @Test
    public void whenGetElFromSllWithFiveElThenReturnWhisEl() {
        stringSimpleLinkList.add("Николай");
        stringSimpleLinkList.add("Петр");
        stringSimpleLinkList.add("Иван");
        stringSimpleLinkList.add("Борис");
        stringSimpleLinkList.add("Игнат");
        String res1 = stringSimpleLinkList.get(1);
        String res2 = stringSimpleLinkList.get(4);
        assertThat(res1,is("Петр"));
        assertThat(res2,is("Игнат"));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation () {
        stringSimpleLinkList.add("Николай");
        stringSimpleLinkList.add("Петр");
        stringSimpleLinkList.add("Иван");
        Iterator<String> it = stringSimpleLinkList.iterator();
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
