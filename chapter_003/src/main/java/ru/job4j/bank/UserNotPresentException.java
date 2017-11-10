package ru.job4j.bank;

public class UserNotPresentException extends RuntimeException {
    private String userName;
    public UserNotPresentException(String userName) {
        this.userName = userName;
    }
    public String toString() {
        return "Пользователя "+this.userName+" не существует!";
    }
}
