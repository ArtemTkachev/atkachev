package ru.job4j;

/**
 * @author atkachev
 * @version 1
 * @since 13.10.2017
 */
public class Task extends Item {

    public Task(String name, String description, long create) {
        this.setName(name);
        this.setDescription(description);
        this.setCreate(create);
    }
}
