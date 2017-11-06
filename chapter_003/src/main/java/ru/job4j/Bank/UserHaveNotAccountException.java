package ru.job4j.Bank;

public class UserHaveNotAccountException extends RuntimeException {
    @Override
    public String toString() {
        return "Такого счета у пользователя нет!";
    }
}
