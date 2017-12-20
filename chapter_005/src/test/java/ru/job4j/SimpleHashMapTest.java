package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleHashMapTest {

    SimpleHashMap<String, String> simpleHashMap;

    @Before
    public void setUp() {
        simpleHashMap = new SimpleHashMap<>();
    }

    @Test
    public void whenInsertKeyAndValueThenHaveValueOnKey() {
        simpleHashMap.insert("0", "Игнат");
        String result = simpleHashMap.get("0");
        assertThat(result, is("Игнат"));
    }

    @Test
    public void whenInsertKeysAndValuesThenHaveValueOnKey() {
        simpleHashMap.insert("0", "Игнат");
        simpleHashMap.insert("1", "Влад");
        simpleHashMap.insert("2", "Георг");
        simpleHashMap.insert("0", "Петр");
        String result = simpleHashMap.get("0");
        assertThat(result, is("Петр"));
    }

    @Test
    public void whenDeleteKeyThenHaveNotValueOnKey() {
        simpleHashMap.insert("0", "Игнат");
        simpleHashMap.delete("0");
        String result = simpleHashMap.get("0");
        assertThat(result, is((String) null));
    }


    @Test
    public void whenAddMore10ElToSmThenSmGrowUp() {
        simpleHashMap.insert("0", "Игнат");
        simpleHashMap.insert("1", "Влад");
        simpleHashMap.insert("2", "Георг");
        simpleHashMap.insert("3", "Петр");
        simpleHashMap.insert("4", "Игнат");
        simpleHashMap.insert("5", "Влад");
        simpleHashMap.insert("6", "Георг");
        simpleHashMap.insert("7", "Петр");
        simpleHashMap.insert("8", "Влад");
        simpleHashMap.insert("9", "Георг");
        simpleHashMap.insert("10", "Петр");
        simpleHashMap.insert("11", "Игнат");
        simpleHashMap.insert("12", "Петр");
        simpleHashMap.insert("13", "Влад");
        simpleHashMap.insert("14", "Георг");
        simpleHashMap.insert("15", "Петр");
        simpleHashMap.insert("16", "Игнат");
        String result = simpleHashMap.get("15");
        assertThat(result, is("Петр"));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocationNoDupl() {
        simpleHashMap.insert("0", "Игнат");
        simpleHashMap.insert("1", "Влад");
        simpleHashMap.insert("2", "Георг");
        simpleHashMap.insert("0", "Петр");
        Iterator<String> it = simpleHashMap.iterator();
        String key = "";
        assertThat(it.hasNext(), is(true));
        key = it.next();
        assertThat(it.hasNext(), is(true));
        key = it.next();
        assertThat(it.hasNext(), is(true));
        key = it.next();
        assertThat(it.hasNext(), is(false));
        it.next();
    }


}
