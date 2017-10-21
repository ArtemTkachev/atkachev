package ru.job4j.chess;

public class ImposibleMoveException extends Exception {
    public String toString() {
        return "Фигура не может пройти на данную ячейку!";
    }
}
