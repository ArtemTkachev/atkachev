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
        simpleHashMap.insert("Прогер", "Игнат");
        String result = simpleHashMap.get("Прогер");
        assertThat(result, is("Игнат"));
    }

    @Test
    public void whenInsertKeysAndValuesThenHaveValueOnKey() {
        simpleHashMap.insert("Прогер", "Игнат");
        simpleHashMap.insert("Инженер", "Влад");
        simpleHashMap.insert("Админ", "Георг");
        simpleHashMap.insert("Прогер", "Петр");
        String result = simpleHashMap.get("Прогер");
        assertThat(result, is("Петр"));
    }

    @Test
    public void whenDeleteKeyThenHaveNotValueOnKey() {
        simpleHashMap.insert("Прогер", "Игнат");
        simpleHashMap.delete("Прогер");
        String result = simpleHashMap.get("Прогер");
        assertThat(result, is((String) null));
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocationNoDupl() {
        simpleHashMap.insert("Прогер", "Игнат");
        simpleHashMap.insert("Инженер", "Влад");
        simpleHashMap.insert("Админ", "Георг");
        simpleHashMap.insert("Прогер", "Петр");
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
