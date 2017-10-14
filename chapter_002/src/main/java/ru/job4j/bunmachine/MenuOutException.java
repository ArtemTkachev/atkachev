package ru.job4j.bunmachine;

public class MenuOutException extends RuntimeException{

    public String toString() {
        return "Выберите пункт меню!";
    }
    
}
