package ru.job4j;

/**
 * @author atkachev
 * @version 1
 * @since 13.10.2017
 */
public interface UserAction {

    //  int key();
    void execute(Input input, Tracker tracker);

    String info();

}
