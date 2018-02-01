package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStorageTest {

    private class ThreadStorage1 extends Thread {
        private final UserStorage userStorage;

        public ThreadStorage1(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            this.userStorage.add(new User(1,1000));
            this.userStorage.delete(new User(1,1000));
            this.userStorage.add(new User(1,1000));
            this.userStorage.update(new User(1,2000));
        }
    }

    private class ThreadStorage2 extends Thread {
        private final UserStorage userStorage;

        public ThreadStorage2(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            this.userStorage.add(new User(2,2000));
            this.userStorage.delete(new User(2,2000));
            this.userStorage.add(new User(2,2000));
            this.userStorage.update(new User(2,4000));
        }
    }

    private class ThreadStorage3 extends Thread {
        private final UserStorage userStorage;

        public ThreadStorage3(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            this.userStorage.transfer(2,1,500);
        }
    }
    @Test
    public void whenExecute3ThreadThenTrue() throws InterruptedException {
        final UserStorage userStorage = new UserStorage();
        Thread first = new ThreadStorage1(userStorage);
        Thread second = new ThreadStorage2(userStorage);
        Thread third = new ThreadStorage3(userStorage);
        first.start();
        second.start();
        first.join();
        second.join();
        third.start();
        third.join();
        assertThat(userStorage.getById(1).getAmount(),is(2500));
        assertThat(userStorage.getById(2).getAmount(),is(3500));
    }


}
