package ru.job4j.chess;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class KnightTest {

    @Test
    public void whenKnightWayThenTrue() {
        try {
            Knight knight = new Knight(new Cell(1, 0), true);
            Cell[] rescells = knight.way(new Cell(2, 2));
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
            Cell[] expectedcells = new Cell[]{new Cell(2, 2)};
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

