package ru.job4j.bunmachine;



public abstract class BaseAction  {
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

    public int GetKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String info() {
        return String.format("%s - %s", this.key, this.name);
    }

   abstract void execute(Input input, MachineStore mstore);
}
