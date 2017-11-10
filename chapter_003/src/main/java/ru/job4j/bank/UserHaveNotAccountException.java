package ru.job4j.bank;

public class UserHaveNotAccountException extends RuntimeException {
    @Override
    public String toString() {
        return "Такого счета у пользователя нет!";
    }
}
