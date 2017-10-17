package ru.job4j;

import java.util.*;

public class ConvertList {

    public List<Integer> toList(int[][] array) {
        List<Integer> listArray = new ArrayList<Integer>();
        for (int[] arel : array) {
            for (int el : arel) {
                listArray.add(el);
            }
        }
        return listArray;
    }

    public int[][] toArray(List<Integer> list, int rows) throws Exception{
        if (list.size()>=rows) {
            int rest = list.size() % rows;
            int count = rest==0 ? list.size() / rows : list.size() / rows + 1;
            int[][] arr = new int[rows][count];
            int index = 0;
            for (int i=0; i<rows; i++) {
                for (int y=0; y<count; y++) {
                    if (list.size() > index) {
                        arr[i][y] = list.get(index);
                        index++;
                    }
                    else {
                        arr[i][y] = 0;
                    }
                }
            }
            return arr;
        }
        else {
            throw new Exception();
        }

    }
}
