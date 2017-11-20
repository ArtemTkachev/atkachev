package ru.job4j;

public class RoleStore extends AbstractStore {
    private int size;
    private SimpleArray<Role> simpleArray;
    public RoleStore(int size) {
        super(size);
    }
}
