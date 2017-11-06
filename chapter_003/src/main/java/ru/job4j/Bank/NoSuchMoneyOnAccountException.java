package ru.job4j.Bank;

public class NoSuchMoneyOnAccountException extends RuntimeException {
    @Override
    public String toString() {
        return "Не хватает денег на счете!";
    }
}
