package ru.job4j.chess;

public abstract class Figure {
   final private Cell position;
   final private boolean isWhite;

   public Figure(Cell position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
   }

   public void clone(Cell cell) {
       this.position.setX(cell.getX());
       this.position.setY(cell.getY());
   }

   public boolean rightCell (Cell cell) {
       boolean ret = false;
       if (cell.getX()==this.position.getX() && cell.getY()==this.position.getY()) {
           ret = true;
       }
       return ret;
   }

    public boolean isWhite () {
       return this.isWhite;
    }

    public Cell getPosition() {
        return position;
    }

    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

}
