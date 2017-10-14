package ru.job4j.bunmachine;

public class NeedMoreCoinsException extends RuntimeException{

    public String toString() {
        return "Не хватает монет для выдачи сдачи!";
    }



}
