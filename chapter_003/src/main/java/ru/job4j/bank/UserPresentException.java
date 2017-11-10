package ru.job4j.bank;

public class UserPresentException extends RuntimeException {
    public String toString() {
        return "Пользователь уже существует!";
    }
}
