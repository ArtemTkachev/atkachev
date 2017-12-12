package ru.job4j;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserMTest {

    @Test
    public void whenGetUserNameThenTrueName() {
        UserM userM = new UserM("Игнат", 0, new GregorianCalendar());
        assertThat(userM.getName(),is("Игнат"));
    }

}
