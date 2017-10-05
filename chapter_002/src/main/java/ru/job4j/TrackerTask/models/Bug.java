package ru.job4j.TrackerTask.models;

public class Bug extends Item {

    public Bug(String name, String description, long create) {
        this.setName(name);
        this.setDescription(description);
        this.setCreate(create);
    }
}
