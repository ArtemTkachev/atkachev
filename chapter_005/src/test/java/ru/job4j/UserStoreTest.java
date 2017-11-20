package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {
    private UserStore userStore;

    @Before
    public void setUp() {
        userStore = new UserStore(100);
    }

    @Test
    public void whenAddUserThenUserStoreHasUserAndReturnUser() {
        User user = new User("0001");
        User returnUser = (User) userStore.add(user);
        assertThat(returnUser,is(user));
    }

    @Test
    public void whenUpdateUserThenUserStoreHasUpdateUserAndReturnOldUser() {
        User user = new User("0001");
        User addUser = (User) userStore.add(user);
        User user2 = new User("0001");
        User returnUser = (User) userStore.update(user2);
        assertThat(returnUser,is(user));
    }

    @Test
    public void whenDeleteUserWithIdThenUserStoreHasNotUserWhithSameIdAndReturnTrue() {
        User user = new User("0001");
        User addUser = (User) userStore.add(user);
        boolean result = userStore.delete("0001");
        assertThat(result,is(true));
    }
}
