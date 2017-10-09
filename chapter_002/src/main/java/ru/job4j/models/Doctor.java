package ru.job4j.models;

public class Doctor extends Profession {

    public Doctor(String fio, String snpassport, boolean degree, int experience) {
        this.degree = degree;
        this.experience = experience;
        this.fio = fio;
        this.snpassport = snpassport;
    }

    public String heal(Patient patient) {
        return "Врач " + this.getFio() + " лечит пациента " + patient.getFio();
    }
}
