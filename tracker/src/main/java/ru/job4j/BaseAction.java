package ru.job4j;

public abstract class BaseAction implements UserAction {
    private int key;
    private String name;

    public BaseAction() {

    }

    public BaseAction(String name, int key) {
        this.key = key;
        this.name = name;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String info() {
        return String.format("%s - %s", this.key, this.name);
    }


}
