package ru.job4j;

public class UserStore extends AbstractStore {
    private int size;
    private SimpleArray<User> simpleArray;
    public UserStore(int size) {
        super(size);
    }

}
