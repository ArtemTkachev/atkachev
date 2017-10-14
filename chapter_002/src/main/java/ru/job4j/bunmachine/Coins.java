package ru.job4j.bunmachine;

public class Coins {
    private int tens = 0;
    private int fives = 0;
    private int twos = 0;
    private int ones = 0;


    public int getTens() {
        return this.tens;
    }

    public int getFives() {
        return this.fives;
    }

    public int getTwos() {
        return this.twos;
    }

    public int getOnes() {
        return this.ones;
    }

    public void setTens(int tens) {
        this.tens = tens;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public void setTwos(int twos) {
        this.twos = twos;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

}
