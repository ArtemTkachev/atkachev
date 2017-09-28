package ru.job4j.loop;

public class Board {

    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        for (int cnth = 0; cnth < height; cnth++) {
            for (int cntw = 0; cntw < width; cntw++) {
                if ((cntw % 2 == 0 && cnth % 2 == 0) || (cntw % 2 != 0 && cnth % 2 != 0))
                    builder.append("X");
                else
                    builder.append(" ");
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }
}
