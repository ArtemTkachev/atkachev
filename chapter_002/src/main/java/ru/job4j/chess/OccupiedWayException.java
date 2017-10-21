package ru.job4j.chess;

public class OccupiedWayException extends Exception {
    public String toString() {
        return "На пути фигуры находятся другие фигуры";
    }
}
