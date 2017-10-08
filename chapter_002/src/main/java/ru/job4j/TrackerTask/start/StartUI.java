package ru.job4j.TrackerTask.start;

import ru.job4j.TrackerTask.models.*;

public class StartUI {

    private static final String MENU = "0.Add new item\r\n" +
            "1.Show all items\r\n" +
            "2.Edit item\r\n" +
            "3.Delete item\r\n" +
            "4.Find item by id\r\n" +
            "5.Find items by name\r\n" +
            "6.Exit program\r\n" +
            "Select: ";
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

    private static final String ADDMENU = "\r\n0.Item\r\n" +
            "1.Task\r\n" +
            "2.Bug\r\n" +
            "Select the type of item: ";

    private String createString(Item item) {
        StringBuilder inform = new StringBuilder();
        inform.append("\r\n");
        inform.append("Name: ");
        inform.append(item.getName());
        inform.append("\r\n");
        inform.append("Description: ");
        inform.append(item.getDescription());
        inform.append("\r\n");
        inform.append("Created: ");
        inform.append(item.getCreate());
        inform.append("\r\n");
        inform.append("ID: ");
        inform.append(item.getId());
        inform.append("\r\n");
        return inform.toString();
    }

    private void findByName(Input input, Tracker tracker) {

        boolean correct = true;
        String error = "";
        String answname = input.ask("Enter the name of the item: ");
        if (answname.isEmpty()) {
            correct = false;
            error = "The entered item name is incorrect!";
        }

        if (correct) {
            //StringBuilder inform = new StringBuilder();
            Item[] allitems = tracker.findByName(answname);
            String inform = "";
            for (Item item : allitems) {
               inform = this.createString(item);
            }
            if (!inform.isEmpty()) {
                System.out.println(inform);
            } else {
                System.out.println("There are no items with the same name in the store!\r\n");
            }
        } else {
            System.out.println(error + "\r\n");
        }
    }

    private void findById(Input input, Tracker tracker) {

        boolean correct = true;
        String error = "";
        String answid = input.ask("Enter the ID of the item: ");
        if (answid.isEmpty()) {
            correct = false;
            error = "The entered item ID is incorrect!";
        }

        if (correct) {
            //StringBuilder inform = new StringBuilder();
            Item item = tracker.findById(answid);
            if (item != null) {
                System.out.println(this.createString(item));
            } else {
                System.out.println("There are no items with the same ID in the store!\r\n");
            }
        } else {
            System.out.println(error + "\r\n");
        }
    }

    private void delete(Input input, Tracker tracker) {
        boolean correct = true;
        String error = "";
        String answid = input.ask("Enter the ID of the item you want to delete: ");
        if (answid.isEmpty()) {
            correct = false;
            error = "The entered item ID is incorrect!";
        }

        if (correct) {
            //StringBuilder inform = new StringBuilder();
            Item item = tracker.findById(answid);
            if (item != null) {
                tracker.delete(item);
                System.out.println(this.createString(item));
                System.out.println("This item was deleted!\r\n");
            } else {
                System.out.println("There are no items with the same ID in the store!\r\n");
            }
        } else {
            System.out.println(error + "\r\n");
        }
    }

    private void edit(Input input, Tracker tracker) {
        boolean correct = true;
        String error = "";
        String answid = input.ask("Enter the ID of the item you want to edit: ");
        if (answid.isEmpty()) {
            correct = false;
            error = "The entered item ID is incorrect!";
        }
        if (correct) {
            //StringBuilder inform = new StringBuilder();
            Item item = tracker.findById(answid);
            if (item != null) {
                System.out.println(this.createString(item));
                String answname = input.ask("Enter the new name of the item: ");
                String answdesc = input.ask("Enter the new description of the item: ");
                if (answdesc.isEmpty()) {
                    correct = false;
                    error = "The entered item description is incorrect!";
                }
                if (answname.isEmpty()) {
                    correct = false;
                    error = "The entered item name is incorrect!";
                }
                if (correct) {
                    Item edititem = new Item(answname, answdesc, item.getCreate());
                    edititem.setId(item.getId());
                    tracker.update(edititem);
                    System.out.println("Update item with id: " + answid + "\r\n");
                } else {
                    System.out.println(error + "\r\n");
                }
            } else {
                System.out.println("There are no items with the same ID in the store!\r\n");
            }
        } else {
            System.out.println(error + "\r\n");
        }


    }

    private void show(Input input, Tracker tracker) {
        //StringBuilder inform = new StringBuilder();
        Item[] allitems = tracker.findAll();
        String inform = "";
        for (Item item : allitems) {
            inform = this.createString(item);
        }
        if (!inform.isEmpty()) {
            System.out.println(inform.toString());
        } else {
            System.out.println("There are no items in the store!\r\n");
        }

    }

    private void add(Input input, Tracker tracker) {

        boolean correct = true;
        String error = "";
        String answtype = input.ask(ADDMENU);
        String answname = input.ask("Enter the name of the item: ");
        String answdesc = input.ask("Enter the description of the item: ");

        if (answdesc.isEmpty()) {
            correct = false;
            error = "The entered item description is incorrect!";
        }
        if (answname.isEmpty()) {
            correct = false;
            error = "The entered item name is incorrect!";
        }
        if (!("0".equals(answtype) || "1".equals(answtype) || "2".equals(answtype))) {
            correct = false;
            error = "The entered item type is incorrect!";
        }

        if (correct) {
            Item item = null;
            if ("0".equals(answtype)) {
                item = new Item(answname, answdesc, System.currentTimeMillis());
            } else if ("1".equals(answtype)) {
                item = new Task(answname, answdesc, System.currentTimeMillis());
            } else if ("2".equals(answtype)) {
                item = new Bug(answname, answdesc, System.currentTimeMillis());
            }
            Item retitem = tracker.add(item);
            System.out.println("Added item with id: " + retitem.getId() + "\r\n");
        } else {
            System.out.println(error + "\r\n");
        }

    }

    public static void main(String[] args) {
        boolean selectexit = true;
        String answer;
        StartUI sui = new StartUI();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        while (selectexit) {
            answer = input.ask(MENU);
            if (EXIT.equals(answer)) {
                selectexit = false;
            } else if (FINDBYNAME.equals(answer)) {
                sui.findByName(input, tracker);
            } else if (FINDBYID.equals(answer)) {
                sui.findById(input, tracker);
            } else if (DELETE.equals(answer)) {
                sui.delete(input, tracker);
            } else if (EDIT.equals(answer)) {
                sui.edit(input, tracker);
            } else if (SHOW.equals(answer)) {
                sui.show(input, tracker);
            } else if (ADD.equals(answer)) {
                sui.add(input, tracker);
            }
        }
    }
}
