package ru.job4j.array;

public class StringContains {
    public boolean contains(String origin, String sub) {
        char[] orgn = origin.toLowerCase().toCharArray();
        char[] sb = sub.toLowerCase().toCharArray();
        int orgnlng = orgn.length;
        int sblng = sb.length;
        int cntfrom = 0;
        int findlimitfr = 0, findlimitto = orgnlng;
        boolean flagcont = false;
        if (orgnlng >= sblng) {
            int i = 0;
            for (int cnt = 0; cnt < sblng; ) {
                for (i = findlimitfr; i < findlimitto; i++) {
                    if (orgn[i] == sb[cnt]) {
                        findlimitfr = i + 1;
                        findlimitto = i + 2;
                        if (cnt == sblng - 1)
                            flagcont = true;
                        if (cnt == 0)
                            cntfrom = i + 1;
                        cnt++;
                        break;
                    } else if (cnt != 0) {
                        cnt = 0;
                        findlimitfr = cntfrom;
                        findlimitto = orgnlng;
                        break;
                    }
                }
                if (cnt == 0 && i == orgnlng)
                    break;
            }
        }
        return flagcont;
    }
}
