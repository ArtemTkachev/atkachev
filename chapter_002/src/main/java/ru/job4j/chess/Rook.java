package ru.job4j.chess;

import java.util.Arrays;

public class Rook extends Figure {

    public Rook(Cell position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int x = dist.getX();
        int y = dist.getY();
        if (x < 8 && y < 8) {
            boolean ready = false;
            Cell[] cells = new Cell[8];
            int index = 0;
            int sec = 0, srX = 0, srY = 0;
            for (int z = 1; z <= 4; z++) {
                while ((z == 1 && x + sec <= 7) ||
                        (z == 2 && y - sec >= 0) ||
                        (z == 3 && x - sec >= 0) ||
                        (z == 4 && y + sec <= 7)) {
                    if (z == 1) {
                        srX = x + sec;
                        srY = y;
                    } else if (z == 2) {
                        srX = x;
                        srY = y - sec;
                    } else if (z == 3) {
                        srX = x - sec;
                        srY = y;
                    } else if (z == 4) {
                        srX = x;
                        srY = y + 1;
                    }
                    Cell cell = new Cell(srX, srY);
                    if (this.rightCell(cell)) {
                        ready = true;
                        break;
                    }
                    cells[index++] = cell;
                    sec++;
                }
                if (ready) {
                    break;
                } else {
                    index = 0;
                    sec = 0;
                    Arrays.fill(cells, null);
                }
            }
            if (ready) {
                Cell[] retWay = new Cell[index];
                System.arraycopy(cells, 0, retWay, 0, index);
                return retWay;
            } else {
                throw new ImposibleMoveException();
            }
        } else {
            throw new ImposibleMoveException();
        }
    }

}
