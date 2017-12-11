package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleHashSetTest {
    private SimpleHashSet<String> stringSimpleHashSet;

    @Before
    public void setUp() {
        stringSimpleHashSet = new SimpleHashSet<>();
    }

    @Test
    public void whenAddElToShsThenShsContEl() {
        stringSimpleHashSet.add("Николай");
        stringSimpleHashSet.add("Петр");
        stringSimpleHashSet.add("Ян");
        stringSimpleHashSet.add("Вячеслав");
        assertThat(stringSimpleHashSet.contains("Николай"), is(true));
    }

    @Test
    public void whenAddElToShsAndRemoveElFromShsThenShsNotContEl() {
        stringSimpleHashSet.add("Николай");
        stringSimpleHashSet.add("Петр");
        stringSimpleHashSet.add("Ян");
        stringSimpleHashSet.add("Вячеслав");
        stringSimpleHashSet.remove("Николай");
        assertThat(stringSimpleHashSet.contains("Николай"), is(false));
    }

}
