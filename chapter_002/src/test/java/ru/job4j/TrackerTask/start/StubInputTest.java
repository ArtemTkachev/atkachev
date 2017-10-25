package ru.job4j.TrackerTask.start;

import org.junit.Test;
import ru.job4j.TrackerTask.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StubInputTest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "task1", "desc1", "6"});
        StartUI sui = new StartUI(input, tracker);
        sui.init();
        assertThat(tracker.findByName("task1").get(0).getName(), is("task1"));
    }

    @Test
    public void whenUserShowAllItemsThenTrackerHasAllItems() {
        Tracker tracker = new Tracker();
        Item task1 = new Task("task1", "desc1", System.currentTimeMillis());
        tracker.add(task1);
        Item task2 = new Task("task2", "desc2", System.currentTimeMillis());
        tracker.add(task2);
        Item task3 = new Task("task3", "desc3", System.currentTimeMillis());
        tracker.add(task3);
        Input input = new StubInput(new String[]{"1", "6"});
        StartUI sui = new StartUI(input, tracker);
        sui.init();
        assertThat(tracker.findAll().size(), is(3));
    }


    @Test
    public void whenUpdateItemThenTrackerHasUpdatedItem() {
        Tracker tracker = new Tracker();
        Item task1 = new Task("task1", "desc1", System.currentTimeMillis());
        tracker.add(task1);
        task1.setId("12345");
        Input input = new StubInput(new String[]{"2", "12345", "task2", "desc2", "6"});
        StartUI sui = new StartUI(input, tracker);
        sui.init();
        assertThat(tracker.findById("12345").getName(), is("task2"));
    }


    @Test
    public void whenUserDeleteItemThenTrackerHasNotSameItem() {
        Tracker tracker = new Tracker();
        Item task1 = new Task("task1", "desc1", System.currentTimeMillis());
        tracker.add(task1);
        task1.setId("12345");
        Input input = new StubInput(new String[]{"3", "12345", "6"});
        StartUI sui = new StartUI(input, tracker);
        sui.init();
        Item expect = null;
        assertThat(tracker.findById("12345"), is(expect));
    }

    @Test
    public void whenUserFindItemByIdThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item task1 = new Task("task1", "desc1", System.currentTimeMillis());
        tracker.add(task1);
        task1.setId("12345");
        Input input = new StubInput(new String[]{"4", "12345", "6"});
        StartUI sui = new StartUI(input, tracker);
        sui.init();
        assertThat(tracker.findById("12345"), is(task1));
    }

    @Test
    public void whenUserFindItemsByNameThenTrackerHasSameItems() {
        Tracker tracker = new Tracker();
        Item task1 = new Task("task1", "desc1", System.currentTimeMillis());
        tracker.add(task1);
        Item task2 = new Task("task1", "desc1", System.currentTimeMillis());
        tracker.add(task2);
        Input input = new StubInput(new String[]{"5", "task1", "6"});
        StartUI sui = new StartUI(input, tracker);
        sui.init();
        assertThat(tracker.findByName("task1").size(), is(2));
    }

    @Test
    public void whenUserExitThenTrackerHasNoItems() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"6"});
        StartUI sui = new StartUI(input, tracker);
        sui.init();
        assertThat(tracker.findAll().size(), is(0));
    }


}
