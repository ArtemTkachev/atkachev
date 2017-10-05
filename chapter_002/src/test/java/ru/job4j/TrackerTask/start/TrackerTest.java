package ru.job4j.TrackerTask.start;

import org.junit.Test;
import ru.job4j.TrackerTask.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {



    @Test
    public void whenAddNewItemThenThenFindItemById() {
        Tracker tracker = new Tracker();
        Item task = new Task("test1","testDescr", System.currentTimeMillis());
        tracker.add(task);
        String id = task.getId();
        assertThat(tracker.findById(id),is(task));
    }

    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Task("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Task("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.update(next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenNoFindItemById() {
        Tracker tracker = new Tracker();
        Item task = new Task("test1","testDescr", System.currentTimeMillis());
        tracker.add(task);
        String id = task.getId();
        tracker.delete(task);
        Item expect = null;
        assertThat(tracker.findById(id),is(expect));
    }

    @Test
    public void whenFindAllItemsThenReturnCorrectItems() {
        Tracker tracker = new Tracker();
        Item task1 = new Task("test1","testDescr", System.currentTimeMillis());
        tracker.add(task1);
        Item task2 = new Task("test2","testDescr", System.currentTimeMillis());
        tracker.add(task2);
        Item task3 = new Task("test3","testDescr", System.currentTimeMillis());
        tracker.add(task3);
        tracker.delete(task2);
        Item[] expectitems = new Item[]{task1, task3};
        Item[] resultitems = tracker.findAll();
        assertThat(resultitems,is(expectitems));
    }

    @Test
    public void whenFindByNameItemsThenReturnCorrectItems() {
        Tracker tracker = new Tracker();
        Item task1 = new Task("test1","testDescr", System.currentTimeMillis());
        tracker.add(task1);
        Item task2 = new Task("test1","testDescr", System.currentTimeMillis());
        tracker.add(task2);
        Item task3 = new Task("test3","testDescr", System.currentTimeMillis());
        tracker.add(task3);
        Item[] expectitems = new Item[]{task1, task2};
        Item[] resultitems = tracker.findByName("test1");
        assertThat(resultitems,is(expectitems));
    }


    @Test
    public void whenFindItemByIdThenReturnCorrectItem() {
        Tracker tracker = new Tracker();
        Item task = new Task("test1","testDescr", System.currentTimeMillis());
        tracker.add(task);
        String id = task.getId();
        Item resulttask = tracker.findById(id);
        assertThat(resulttask,is(task));
    }



}
