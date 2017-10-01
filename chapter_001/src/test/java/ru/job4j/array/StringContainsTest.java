package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringContainsTest {

@Test
    public  void whenStringOriginContainsStringSubThenTrue() {
        StringContains sc = new StringContains();
        boolean res = sc.contains("Приветик", "ик");
        assertThat(res,is(true));
    }
}
