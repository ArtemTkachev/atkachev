package ru.job4j.TrackerTask.start;

import ru.job4j.TrackerTask.models.*;

import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int count = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
        items[count++] = item;
        return item;
    }

    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < this.count; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    public void delete(Item item) {
        String id = item.getId();
        for (int i = 0; i < this.count; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = null;
                break;
            }
        }

    }

    public Item[] findAll() {
        Item[] findAll = new Item[this.count];
        int y = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.items[i] != null) {
                findAll[y] = this.items[i];
                y++;
            }
        }
        Item[] result = new Item[y];
        System.arraycopy(findAll, 0, result, 0, y);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] findnames = new Item[this.count];
        int y = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                findnames[y] = this.items[i];
                y++;
            }
        }
        Item[] result = new Item[y];
        System.arraycopy(findnames, 0, result, 0, y);
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item itemc : items) {
            if (itemc != null && itemc.getId().equals(id)) {
                result = itemc;
                break;
            }
        }
        return result;
    }

}
