package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListUserConvertToHashMapThenHashMap() {
        UserConvert userConvert = new UserConvert();
        HashMap<Integer,User> result = userConvert.process(Arrays.asList(
                new User(1,"Первый","Ростов"),
                new User(2,"Второй","Москва"),
                new User(3,"Третий","Питер")));

        HashMap<Integer,User> except = new HashMap<Integer, User>();
        except.put(1,new User(1,"Первый","Ростов"));
        except.put(2,new User(2,"Второй","Москва"));
        except.put(3,new User(3,"Третий","Питер"));

        assertThat(result,is(except));

    }
}
