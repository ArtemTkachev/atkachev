package ru.job4j;

public class MainJmm {
    private int firstVar;
    private int secondVar;

    public MainJmm(int firstVar, int secondVar) {
        this.firstVar = firstVar;
        this.secondVar = secondVar;
    }

    public int getFirstVar() {
        return firstVar;
    }

    public int getSecondVar() {
        return secondVar;
    }

    public void setFirstVar(int firstVar) {
        this.firstVar = firstVar;
    }

    public void setSecondVar(int secondVar) {
        this.secondVar = secondVar;
    }
}
