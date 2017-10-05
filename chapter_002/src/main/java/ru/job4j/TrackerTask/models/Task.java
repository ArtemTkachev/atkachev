package ru.job4j.TrackerTask.models;

public class Task extends Item {

    public Task(String name, String description, long create) {
        this.setName(name);
        this.setDescription(description);
        this.setCreate(create);
    }
}
