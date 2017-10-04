package ru.job4j.models;

public class Profession {
    public String fio;
    public String snpassport;
    public boolean degree;
    public int experience;

    public Profession(){

    }

    public Profession(String fio, String snpassport, boolean degree, int experience) {
        this.degree = degree;
        this.experience = experience;
        this.fio = fio;
        this.snpassport = snpassport;
    }

    public String getFio() {
        return this.fio;
    }
    public String getSnpassport() {
        return this.snpassport;
    }
    public boolean getDegree() {
        return this.degree;
    }
    public int getExperience() {
        return this.experience;
    }

}
