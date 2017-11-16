package ru.job4j;

/**
 * @author atkachev
 * @version 1
 * @since 13.10.2017
 */

public interface Input {

    String ask(String question);

    int ask(String question, int[] range);

}
