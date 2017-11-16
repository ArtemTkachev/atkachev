package ru.job4j;

/**
 * @author atkachev
 * @version 1
 * @since 13.10.2017
 */

public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /*
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
                StringBuilder inform = new StringBuilder();
                for (Item item : allitems) {
                    inform.append(this.createString(item));
                }
                if (inform.length()!=0) {
                    System.out.println(inform.toString());
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
            StringBuilder inform = new StringBuilder();
            for (Item item : allitems) {
                inform.append(this.createString(item));
            }
            if (inform.length()!=0) {
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
    */
/*
    public void init() {
        boolean selectexit = true;
        String answer;
        while (selectexit) {
            answer = input.ask(MENU);
            if (EXIT.equals(answer)) {
                selectexit = false;
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName(input, tracker);
            } else if (FINDBYID.equals(answer)) {
                this.findById(input, tracker);
            } else if (DELETE.equals(answer)) {
                this.delete(input, tracker);
            } else if (EDIT.equals(answer)) {
                this.edit(input, tracker);
            } else if (SHOW.equals(answer)) {
                this.show(input, tracker);
            } else if (ADD.equals(answer)) {
                this.add(input, tracker);
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
       // new StartUI(new StubInput(new String[]{"1", "2", "3", "4"}), new Tracker()).init();

    }

    */
    public void init() {
        boolean selectexit = true;
        int answer;
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        while (selectexit) {
            menuTracker.show();
            System.out.println("6 - Exit program");
            answer = input.ask("Select action: ", menuTracker.actionkeys());
            if (6 == answer)
                selectexit = false;
            else
                menuTracker.selectAction(answer);
        }


    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        StartUI sui = new StartUI(input, tracker);
        sui.init();
    }

}
