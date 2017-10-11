package ru.job4j.TrackerTask.start;


import ru.job4j.TrackerTask.models.Item;



class FindItemsByName implements UserAction {

    public int key() {
        return 5;
    }

    public void execute(Input input, Tracker tracker) {
        String answname = input.ask("Enter the name of the item: ");
        Item[] items = tracker.findByName(answname);
        for (Item item : items) {
            System.out.println(String.format("ID: %s Name: %s", item.getId(), item.getName()));
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Find items by name");
    }

}


public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] userActions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.userActions[0] = this.new AddItem();
        this.userActions[1] = new MenuTracker.ShowAllItems();
        this.userActions[2] = new EditItem();
        this.userActions[3] = new DeleteItem();
        this.userActions[4] = new FindItemById();
        this.userActions[5] = new FindItemsByName();
    }

    public void show() {
        for (UserAction action : this.userActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void selectAction(int key) {
        this.userActions[key].execute(this.input, this.tracker);
    }

    public int[] actionkeys () {
        int[] keys = new int[this.userActions.length];
        for (int i = 0; i<this.userActions.length; i++) {
            keys[i]=userActions[i].key();
        }
        return keys;
    }

    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String answname = input.ask("Enter the name of the item: ");
            String answdesc = input.ask("Enter the description of the item: ");
            tracker.add(new Item(answname, answdesc, System.currentTimeMillis()));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new item");
        }

    }

    private static class ShowAllItems implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("ID: %s Name: %s", item.getId(), item.getName()));
            }

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }

    }

    private class EditItem implements UserAction {

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String answid = input.ask("Enter the ID of the item you want to edit: ");
            String answname = input.ask("Enter the new name of the item: ");
            String answdesc = input.ask("Enter the new description of the item: ");
            Item item = new Item(answname, answdesc, System.currentTimeMillis());
            item.setId(answid);
            tracker.update(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }

    }

    private class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String answid = input.ask("Enter the ID of the item you want to delete: ");
            Item item = tracker.findById(answid);
            if (item != null)
                tracker.delete(item);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }

    }

    private class FindItemById implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String answid = input.ask("Enter the ID of the item: ");
            Item item = tracker.findById(answid);
            if (item != null)
                System.out.println(String.format("ID: %s Name: %s", item.getId(), item.getName()));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id");
        }

    }


}
