package ru.job4j;


public class FirstThreadJmm implements Runnable {
    private MainJmm mainJmm;
    private int SecVarGet;
    public FirstThreadJmm(MainJmm mainJmm) {
        this.mainJmm = mainJmm;
    }

    @Override
    public void run() {
        this.mainJmm.setFirstVar(this.mainJmm.getFirstVar() + 1);
        this.mainJmm.setSecondVar(this.mainJmm.getSecondVar() +1);
        this.SecVarGet = this.mainJmm.getSecondVar();
    }

    public int getSecVarGet() {
        return SecVarGet;
    }
}
