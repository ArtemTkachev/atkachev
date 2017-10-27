package ru.job4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SortUserTest {
    @Test
    public void whenSortTreeSetThenTrueSort() {
        SortUser sortUser = new SortUser();
        List<UserSort> list = Arrays.asList(new UserSort("Иван",12),
                new UserSort("Петр",33),
                new UserSort("Максим", 21),
                new UserSort("Игорь", 21),
                new UserSort("Игнат", 6));
        Set<UserSort> resultSet = sortUser.sort(list);
        UserSort[] usersex = new UserSort[] {new UserSort("Петр",33),
                new UserSort("Игорь", 21),
                new UserSort("Максим",21),
                new UserSort("Иван", 12),
                new UserSort("Игнат", 6)};
        UserSort[] usersres = resultSet.toArray( new UserSort[resultSet.size()]);
        assertThat(usersres,is(usersex));

    }
}
