package ru.job4j.chess;

import java.util.Arrays;
import java.util.List;

public class Knight extends Figure {

    public Knight(Cell position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int x = dist.getX();
        int y = dist.getY();
        if (x < 8 && y < 8) {
            boolean ready = false;
            Cell[] cells = new Cell[2];
            int index = 0;
            int sec1 = 0, sec2 = 0, srX = 0, srY = 0;
            for (int z = 1; z <= 8; z++) {
                while (sec1 < 2 && ((z == 1 && y + sec1 <= 7 && x + sec2 <= 7) ||
                        (z == 2 && x + sec2 <= 7 && y - sec1 >= 0) ||
                        (z == 3 && x + sec1 <= 7 && y - sec2 >= 0) ||
                        (z == 4 && x - sec1 >= 0 && y - sec2 >= 0) ||
                        (z == 5 && x - sec2 >= 0 && y - sec1 >= 0) ||
                        (z == 6 && x - sec2 >= 0 && y + sec1 <= 7) ||
                        (z == 7 && x - sec1 >= 0 && y + sec2 <= 7) ||
                        (z == 8 && x + sec1 <= 7 && y + sec2 <= 7))) {
                    if (z == 1 || z == 2) {
                        srX = x + sec2;
                    } else if (z == 3 || z == 8) {
                        srX = x + sec1;
                    } else if (z == 4 || z == 7) {
                        srX = x - sec1;
                    } else if (z == 5 || z == 6) {
                        srX = x - sec2;
                    }
                    if (z == 7 || z == 8) {
                        srY = y + sec2;
                    } else if (z == 1 || z == 6) {
                        srY = y + sec1;
                    } else if (z == 2 || z == 5) {
                        srY = y - sec1;
                    } else if (z == 3 || z == 4) {
                        srY = y - sec2;
                    }
                    Cell cell = new Cell(srX, srY);
                    if (this.rightCell(cell)) {
                        ready = true;
                        break;
                    }
                    cells[index++] = cell;
                    sec1++;
                    sec2 = sec2 + 2;
                }
                if (ready) {
                    break;
                } else {
                    index = 0;
                    sec1 = 0;
                    sec2 = 0;
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
