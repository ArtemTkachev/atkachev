package ru.job4j.bunmachine;

public class NeedPriceForBunsException extends RuntimeException{

    public String toString() {
        return "Не назначена цена пончиков в автомате!";
    }



}
