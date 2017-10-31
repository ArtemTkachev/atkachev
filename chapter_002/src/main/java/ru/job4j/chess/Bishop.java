package ru.job4j.chess;

import java.util.Arrays;

public class Bishop extends Figure {

    public Bishop(Cell position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int xd = dist.getX();
        int yd = dist.getY();
        int xp = this.getPosition().getX();
        int yp = this.getPosition().getY();
        if (xd < 8 && yd < 8) {
            Cell[] cells = new Cell[7];
            int index = 0;
            int deltax = xd - xp;
            int fx = deltax < 0 ? -1 : 1;
            int deltay = yd - yp;
            int fy = deltay < 0 ? -1 : 1;
            if (Math.abs(deltax) != Math.abs(deltay)) {
                throw new ImposibleMoveException();
            }
            for (int z = 0; z < Math.abs(deltax); z++) {
                Cell cell = new Cell(xd - z * fx, yd - z * fy);
                cells[index++] = cell;
            }
            Cell[] retWay = new Cell[index];
            System.arraycopy(cells, 0, retWay, 0, index);
            return retWay;
        } else {
            throw new ImposibleMoveException();
        }
    }

}

