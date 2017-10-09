package ru.job4j.array;

public class TwoArraysInOne {

    public int[] retArray(int[] firstarray, int[] secondarray) {
        int[] resultarray = new int[firstarray.length + secondarray.length];
        int i = 0;
        int y = 0;
        for (int cnt = 0; cnt < resultarray.length; cnt++) {
            if (i < firstarray.length && y < secondarray.length) {
                if (firstarray[i] < secondarray[y]) {
                    resultarray[cnt] = firstarray[i];
                    i++;
                } else {
                    resultarray[cnt] = secondarray[y];
                    y++;
                }
            } else if (i >= firstarray.length) {
                /*
                resultarray[cnt]=secondarray[y];
                y++;
                */
                System.arraycopy(secondarray, y, resultarray, cnt, secondarray.length-y );
                break;
            } else if (y >= secondarray.length) {
               /*
                resultarray[cnt]=firstarray[i];
                i++;
                 */
                System.arraycopy(firstarray, i, resultarray, cnt, firstarray.length-i );
                break;
            }
        }

        return resultarray;
    }
}
