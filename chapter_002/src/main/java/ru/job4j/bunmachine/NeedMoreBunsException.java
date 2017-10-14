package ru.job4j.bunmachine;

public class NeedMoreBunsException extends RuntimeException{

    public String toString() {
        return "Не хватает пончиков в автомате!";
    }



}
