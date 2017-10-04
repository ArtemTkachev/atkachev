package ru.job4j.models;

public class Teacher extends Profession {

    public Teacher(String fio, String snpassport, boolean degree, int experience) {
        this.degree = degree;
        this.experience = experience;
        this.fio = fio;
        this.snpassport = snpassport;
    }

    public String teach(Student student) {
        return "Учитель "+ this.getFio()+ " преподает студенту "+ student.getFio();
    }
}
