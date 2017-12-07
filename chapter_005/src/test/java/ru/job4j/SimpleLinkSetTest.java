package ru.job4j;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleLinkSetTest {
    private SimpleLinkSet<String> stringSimpleLinkSet;

    @Before
    public void setUp() {
        stringSimpleLinkSet = new SimpleLinkSet<>();
    }

    @Test
    public void whenAddElToSlsThenSlsHaveEl() {
        stringSimpleLinkSet.add("Николай");
        Iterator<String> it = stringSimpleLinkSet.iterator();
        assertThat(it.next(), is("Николай"));
    }


    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocationNoDupl () {
        stringSimpleLinkSet.add("Николай");
        stringSimpleLinkSet.add("Петр");
        stringSimpleLinkSet.add("Иван");
        stringSimpleLinkSet.add("Петр");
        Iterator<String> it = stringSimpleLinkSet.iterator();
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
