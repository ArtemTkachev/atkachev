package ru.job4j.chess;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PawnTest {

    @Test
    public void whenPawnWayThenTrue() {
        try {
            Pawn pawn = new Pawn(new Cell(4, 1), true);
            Cell[] rescells = pawn.way(new Cell(4, 3));
            int[] crsr = new int[rescells.length * 2];
            int zcr = 0;
            for (int z = 0; z < crsr.length; z++) {
                if (z % 2 == 0)
                    crsr[z] = rescells[zcr].getX();
                else {
                    crsr[z] = rescells[zcr].getY();
                    zcr++;
                }
            }
            Cell[] expectedcells = new Cell[]{new Cell(4, 3), new Cell(4,2)};
            int[] crse = new int[expectedcells.length * 2];
            int zce = 0;
            for (int z = 0; z < crse.length; z++) {
                if (z % 2 == 0)
                    crse[z] = expectedcells[zce].getX();
                else {
                    crse[z] = expectedcells[zce].getY();
                    zce++;
                }
            }
            assertThat(crsr, is(crse));

        } catch (ImposibleMoveException ime) {
            System.out.println(ime);
        }
    }
}