package ru.job4j.bank;

public class NoSuchMoneyOnAccountException extends RuntimeException {
    @Override
    public String toString() {
        return "Не хватает денег на счете!";
    }
}
