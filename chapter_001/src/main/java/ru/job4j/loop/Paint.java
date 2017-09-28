package ru.job4j.loop;

public class Paint {

    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        int frml = h + (h - 1);
        for (int cnth = 0; cnth < h; cnth++) {
            for (int cntw = 0; cntw < frml; cntw++) {
                if (cntw >= frml - (h + cnth) && cntw < h + cnth)
                    builder.append("^");
                else
                    builder.append(" ");
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }
}
