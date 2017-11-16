package ru.job4j;

/**
 * @author atkachev
 * @version 1
 * @since 13.10.2017
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }


    public int ask(String question, int[] range) {
        return -1;
    }
}