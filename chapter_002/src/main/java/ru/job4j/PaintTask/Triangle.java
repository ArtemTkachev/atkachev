package ru.job4j.PaintTask;

public class Triangle implements Shape {

    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("  *  \n");
        sb.append(" *** \n");
        sb.append("*****\n");
        return sb.toString();
    }
}
