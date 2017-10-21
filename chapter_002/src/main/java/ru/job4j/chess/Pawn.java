package ru.job4j.chess;

import java.util.Arrays;

public class Pawn extends Figure {

    public Pawn(Cell position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int x = dist.getX();
        int y = dist.getY();
        if (x < 8 && y < 8) {
            boolean ready = false;
            Cell[] cells = new Cell[3];
            int index = 0;
            int sec = 0, srX = 0, srY = 0;
            for (int z = 1; z <= 4; z++) {
                while (((sec < 3 && (z == 2 || z == 4)) || (sec < 2 && z != 2 && z != 4)) &&
                        ((z == 1 && y + sec <= 7 && !this.isWhite()) ||
                                //       (z == 2 && x + sec <= 7 && y + sec <= 7 && !this.isWhite()) ||
                                //      (z == 3 && x - sec >= 0 && y + sec <= 7 && !this.isWhite()) ||
                                (z == 2 && y + sec <= 7 && !this.isWhite() && y == 4) ||
                                (z == 3 && y - sec >= 0 && this.isWhite()) ||
                                //      (z == 6 && x + sec <= 7 && y - sec >= 0 && this.isWhite()) ||
                                //      (z == 7 && x - sec >= 0 && y - sec >= 0 && this.isWhite()) ||
                                (z == 4 && y - sec <= 7 && this.isWhite() && y == 3))) {
                    if (z == 1 || z == 2 || z == 3 || z == 4) {
                        srX = x;
                    }
                    //else if (z == 2 || z == 6) {
                    //   srX = x + sec;
                    // } else if (z == 3 || z == 7) {
                    //    srX = x - sec;
                    // }
                    if (z == 1 || z == 2) {
                        srY = y + sec;
                    } else if (z == 3 || z == 4) {
                        srY = y - sec;
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
        } else

        {
            throw new ImposibleMoveException();
        }
    }

}