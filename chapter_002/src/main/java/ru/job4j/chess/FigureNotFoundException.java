package ru.job4j.chess;

public class FigureNotFoundException extends Exception {
    public String toString() {
        return "Фигура не найдена на данном поле!";
    }
}
