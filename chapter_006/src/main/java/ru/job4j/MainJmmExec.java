package ru.job4j;

public class MainJmmExec {
    public static void main(String[] args) {
        MainJmm mainJmm = new MainJmm(1, 1);

        // Race Conditions
        // Visibility of Shared Objects
        FirstThreadJmm frst = new FirstThreadJmm(mainJmm);
        Thread first = new Thread(frst);
        SecondThreadJmm scnd = new SecondThreadJmm(mainJmm);
        Thread second = new Thread(scnd);
        FirstThreadJmm frst2 = new FirstThreadJmm(mainJmm);
        Thread first2 = new Thread(frst2);
        SecondThreadJmm scnd2 = new SecondThreadJmm(mainJmm);
        Thread second2 = new Thread(scnd2);

        Thread result1 = new Thread() {
            @Override
            public void run() {
                System.out.println(String.format("%s - first variant", String.valueOf(mainJmm.getFirstVar())));
            }
        };

        Thread result2 = new Thread() {
            @Override
            public void run() {
                System.out.println(String.format("%s - second variant in 1Thread", String.valueOf(frst2.getSecVarGet())));
                System.out.println(String.format("%s - second variant in 2Thread", String.valueOf(scnd2.getSecVarGet())));
            }
        };


        try {
            first.start();
            second.start();
            first.join();
            second.join();
            result1.start();
            result1.join();

            mainJmm.setSecondVar(1);
            first2.start();
            first2.join();
            second2.start();
            second2.join();
            result2.start();
            result2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
