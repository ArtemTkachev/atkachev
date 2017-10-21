package ru.job4j.chess;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void whenRookSourceCellThenTrueSourceCell() {
        try {
            Board board = new Board(new Figure[]{new Rook(new Cell(0, 0), true)});
            boolean result = board.move(new Cell(0, 0), new Cell(0, 5));
            assertThat(result, is(true));
        } catch (FigureNotFoundException fne) {
            System.out.println(fne);
        } catch (ImposibleMoveException ime) {
            System.out.println(ime);
        } catch (OccupiedWayException owe) {
            System.out.println(owe);
        }
    }

    @Test
    public void whenRookWayThenImposibleMove() {
        try {
            Board board = new Board(new Figure[]{new Rook(new Cell(0, 0), true)});
            boolean result = board.move(new Cell(0, 0), new Cell(1, 5));
            assertThat(result, is(true));
        } catch (FigureNotFoundException fne) {
            System.out.println(fne);
        } catch (ImposibleMoveException ime) {
            System.out.println(ime);
        } catch (OccupiedWayException owe) {
            System.out.println(owe);
        }
    }

    @Test
    public void whenRookSourceCellThenFalseSourceCell() {
        try {
            Board board = new Board(new Figure[]{new Rook(new Cell(1, 0), true)});
            boolean result = board.move(new Cell(0, 0), new Cell(0, 5));
            assertThat(result, is(true));
        } catch (FigureNotFoundException fne) {
            System.out.println(fne);
        } catch (ImposibleMoveException ime) {
            System.out.println(ime);
        } catch (OccupiedWayException owe) {
            System.out.println(owe);
        }
    }

    @Test
    public void whenRookWayThenOccupiedWay() {
        try {
            Board board = new Board(new Figure[]{new Rook(new Cell(0, 0), true), new Bishop(new Cell(0,2),true)});
            boolean result = board.move(new Cell(0, 0), new Cell(0, 5));
            assertThat(result, is(true));
        } catch (FigureNotFoundException fne) {
            System.out.println(fne);
        } catch (ImposibleMoveException ime) {
            System.out.println(ime);
        } catch (OccupiedWayException owe) {
            System.out.println(owe);
        }
    }
}
