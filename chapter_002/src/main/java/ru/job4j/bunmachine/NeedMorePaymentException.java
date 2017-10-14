package ru.job4j.bunmachine;

public class NeedMorePaymentException extends RuntimeException{

    public String toString() {
        return "Внесите больше средств для покупки пончиков!";
    }



}
