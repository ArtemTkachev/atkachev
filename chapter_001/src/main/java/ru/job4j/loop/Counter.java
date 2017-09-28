package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {
        int result = 0;
        for (int cnt = start; cnt <= finish; cnt++) {

            if (cnt % 2 == 0) {
                result = result + cnt;
            }
        }
        return result;
    }

}
