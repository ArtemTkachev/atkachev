package ru.job4j.TrackerTask.start;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        if (key == 6)
            exist = true;
        else {
            for (int val : range) {
                if (val == key) {
                    exist = true;
                    break;
                }
            }
        }
        if (exist) {
            return key;

        } else {
            throw new MenuOutException("Out of menu range! ");
        }
    }

    ;
}
