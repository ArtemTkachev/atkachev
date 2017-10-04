package ru.job4j.checkprof;

import ru.job4j.models.*;

public class CheckProf {

    public String[] checkProfession(String[] profNames, String[] clientNames) {
        String[] checkProf = new String[3];

        Profession[] profs = new Profession[3];
        Client[] clients = new Client[3];

        profs[0] = new Teacher(profNames[0], "", true, 10);
        profs[1] = new Engineer(profNames[1], "", true, 10);
        profs[2] = new Doctor(profNames[2], "", true, 10);

        clients[0] = new Student(clientNames[0]);
        clients[1] = new Employer(clientNames[1]);
        clients[2] = new Patient(clientNames[2]);


        for (int i = 0; i < profs.length; i++) {
            if (profs[i] instanceof Teacher && clients[i] instanceof Student) {
                checkProf[i] = ((Teacher) profs[i]).teach(((Student) clients[i]));
            }
            if (profs[i] instanceof Engineer && clients[i] instanceof Employer) {
                checkProf[i] = ((Engineer) profs[i]).developfor(((Employer) clients[i]));
            }
            if (profs[i] instanceof Doctor && clients[i] instanceof Patient) {
                checkProf[i] = ((Doctor) profs[i]).heal(((Patient) clients[i]));
            }
        }

        return checkProf;
    }
}
