package ru.job4j;

/**
 * @author atkachev
 * @version 1
 * @since 13.10.2017
 */

public class Item {
    private String name;
    private String desc;
    private long created;
    private String id;
    private String[] comments;

    public Item() {

    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.desc = description;
        this.created = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.desc;
    }

    public long getCreate() {
        return this.created;
    }

    public String getId() {
        return this.id;
    }

    public String[] getComments() {
        return this.comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public void setCreate(long create) {
        this.created = create;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

}
