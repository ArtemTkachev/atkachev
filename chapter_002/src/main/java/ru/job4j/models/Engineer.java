package ru.job4j.models;

public class Engineer extends Profession {

    public Engineer(String fio, String snpassport, boolean degree, int experience) {
        this.degree = degree;
        this.experience = experience;
        this.fio = fio;
        this.snpassport = snpassport;
    }

    public String developfor(Employer employer) {
        return "Инженер "+ this.getFio()+ " работает на заказчика "+ employer.getFio();
    }
}
