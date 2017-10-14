package ru.job4j.bunmachine;


import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int ask(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                System.out.print(question);
                value =  Integer.valueOf(scanner.nextLine());
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again. ");
            }
        } while (invalid);
        return value;
    }

    private int checkOutException(String question, int[] range) {
        int key = this.ask(question);
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
            throw new MenuOutException();
        }
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.checkOutException(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println(moe.toString());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again. ");
            }
        } while (invalid);
        return value;
    }
}
