package ru.job4j.array;

public class RotateArray {

    public int[][] rotate(int[][] array) {
        int tmp;
        int arlng = array.length;
        for (int cnt = 0; cnt < Math.floor(arlng / 2); cnt++) {
            for (int i = 0; i < arlng - 1 - cnt*2; i++) {
                tmp = array[cnt][i + cnt];
                array[cnt][i + cnt] = array[arlng - 1 - cnt - i][cnt];
                array[arlng - 1 - cnt - i][cnt] = array[arlng - 1 - cnt][arlng - 1 - cnt - i];
                array[arlng - 1 - cnt][arlng - 1 - cnt - i] = array[i + cnt][arlng - 1 - cnt];
                array[i + cnt][arlng - 1 - cnt] = tmp;
            }
        }
        return array;
    }

}
