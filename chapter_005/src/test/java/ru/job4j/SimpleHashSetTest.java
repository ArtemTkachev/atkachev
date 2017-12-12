package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleHashSetTest {
    private SimpleHashSet<String> stringSimpleHashSet;
    private SimpleHashSet<Integer> integerSimpleHashSet;

    @Before
    public void setUp() {
        stringSimpleHashSet = new SimpleHashSet<>();
        integerSimpleHashSet = new SimpleHashSet<>();
    }

    @Test
    public void whenAddElToShsThenShsContEl() {
        stringSimpleHashSet.add("Николай");
        stringSimpleHashSet.add("Петр");
        stringSimpleHashSet.add("Ян");
        stringSimpleHashSet.add("Вячеслав");
        integerSimpleHashSet.add(0);
        integerSimpleHashSet.add(1);
        integerSimpleHashSet.add(2);
        assertThat(stringSimpleHashSet.contains("Николай"), is(true));
        assertThat(integerSimpleHashSet.contains(0),is(true));
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
