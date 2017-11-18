package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    private  SimpleArray<String> stringSimpleArray;
    private  SimpleArray<Integer> integerSimpleArray;

    @Before
    public void setUp(){
        stringSimpleArray = new SimpleArray<String>(10);
        integerSimpleArray = new SimpleArray<Integer>(10);
    }

    @Test
    public void whenAddObjectShouldReturnTheSameTypeAndFindObject() {
        String resultStr = stringSimpleArray.add("Первый");
        assertThat(resultStr,is("Первый"));
        assertThat(stringSimpleArray.get(0),is("Первый"));
        Integer resultInt = integerSimpleArray.add(13);
        assertThat(resultInt,is(13));
        assertThat(integerSimpleArray.get(0),is(13));
    }

    @Test
    public void whenDeleteObjectShouldReturnTrueAndNoFindObject() {
        String first = stringSimpleArray.add("Первый");
        boolean res = stringSimpleArray.delete(0);
        assertThat(res,is(true));
        assertThat(stringSimpleArray.get(0),is((String) null));
        Integer firstInt = integerSimpleArray.add(13);
        boolean resInt = integerSimpleArray.delete(0);
        assertThat(resInt,is(true));
        assertThat(integerSimpleArray.get(0),is((String) null));
    }

    @Test
    public void whenGetObjectShouldReturnTheSameTypeAndFindObject() {
        String first = stringSimpleArray.add("Первый");
        String firstGet = stringSimpleArray.get(0);
        assertThat(firstGet,is(first));
        Integer firstInt = integerSimpleArray.add(13);
        Integer firstGetInt = integerSimpleArray.get(0);
        assertThat(firstGetInt,is(firstInt));
    }

    @Test
    public void whenUpdateObjectShouldReturnTheSameTypeWithSameObjectAndFindNewObject() {
        String first = stringSimpleArray.add("Первый");
        String firstUpdate = stringSimpleArray.update("Первый");
        assertThat(firstUpdate,is(first));
        assertThat(stringSimpleArray.get(0),is("Первый"));
        Integer firstInt = integerSimpleArray.add(13);
        Integer firstUpdateInt = integerSimpleArray.update(13);
        assertThat(firstUpdateInt,is(firstInt));
        assertThat(integerSimpleArray.get(0),is(13));
    }
}
