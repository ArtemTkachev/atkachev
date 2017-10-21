package ru.job4j.chess;

import java.util.Arrays;

public class Board {
    /*
        private Figure[] figures = new Figure[]{new Rook(new Cell(0, 0), true), new Knight(new Cell(1, 0), true), new Bishop(new Cell(2, 0), true), new Queen(new Cell(3, 0), true),
                new King(new Cell(4, 0), true), new Bishop(new Cell(5, 0), true), new Knight(new Cell(6, 0), true), new Rook(new Cell(7, 0), true),
                new Pawn(new Cell(0, 1), true), new Pawn(new Cell(1, 1), true), new Pawn(new Cell(2, 1), true), new Pawn(new Cell(3, 1), true),
                new Pawn(new Cell(4, 1), true), new Pawn(new Cell(5, 1), true), new Pawn(new Cell(6, 1), true), new Pawn(new Cell(7, 1), true),
                new Pawn(new Cell(0, 6), false), new Pawn(new Cell(1, 6), false), new Pawn(new Cell(2, 6), false), new Pawn(new Cell(3, 6), false),
                new Pawn(new Cell(4, 6), false), new Pawn(new Cell(5, 6), false), new Pawn(new Cell(6, 6), false), new Pawn(new Cell(7, 6), false),
                new Rook(new Cell(0, 7), false), new Knight(new Cell(1, 7), false), new Bishop(new Cell(2, 7), false), new Queen(new Cell(3, 7), false),
                new King(new Cell(4, 7), false), new Bishop(new Cell(5, 7), false), new Knight(new Cell(6, 7), false), new Rook(new Cell(7, 7), false)};
    */
    private Figure[] figures;

    public Board(Figure[] figures) {
        this.figures = figures;
    }


    public boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean step = false;
        for (Figure figure : figures) {
            if (figure.rightCell(source)) {
                try {
                    Cell[] cells = figure.way(dist);
                    for(int i =0; i<cells.length; i++) {
                        for (Figure figureint : figures) {
                            if (figureint.rightCell(cells[i])) {
                                throw new OccupiedWayException();
                            }
                        }
                    }
                    figure.clone(dist);
                    step = true;
                } catch (ImposibleMoveException ime) {
                    throw ime;
                }
                break;
            } else {
                throw new FigureNotFoundException();
            }
        }
        return step;
    }

}