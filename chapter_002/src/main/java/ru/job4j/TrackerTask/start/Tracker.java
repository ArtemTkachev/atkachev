package ru.job4j.TrackerTask.start;

import ru.job4j.TrackerTask.models.*;

import java.util.ArrayList;
import java.util.Random;

public class Tracker {
    private ArrayList<Item> items = new ArrayList<Item>();
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
        items.add(item);
        return item;
    }

    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                items.set(i,item);
                break;
            }
        }
    }

    public void delete(Item item) {
        String id = item.getId();
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                items.set(i,null);
                break;
            }
        }

    }

    public  ArrayList<Item> findAll() {
        ArrayList<Item> findAll = new ArrayList<Item>();
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null) {
                findAll.add(this.items.get(i));
            }
        }
        return findAll;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> findnames = new ArrayList<Item>();
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getName().equals(key)) {
                findnames.add(this.items.get(i));
            }
        }
        return findnames;
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
