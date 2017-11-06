package ru.job4j.Bank;

public class UserPresentException extends RuntimeException {
    public String toString() {
        return "Пользователь уже существует!";
    }
}
