package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1;
        if (n != 0) {
            for (int cnt = n; n > 0; n--) {
                result = result * n;
            }
        }
        return result;
    }
}
