package ru.job4j;

import java.util.*;

import static java.util.Arrays.*;


public class ArraysSort {


    public Set<ComparedList> sortAsc(ArrayList<Integer[]> arrayList) {
        Set<ComparedList> sortSet = new TreeSet<ComparedList>();
        for (Integer[] el: arrayList) {
            sortSet.add(new ComparedList(new ArrayList<Integer>(Arrays.asList(el))));
        }
        return sortSet;
    }

    public Set<ComparedList> sortDesc(ArrayList<Integer[]> arrayList) {
        Set<ComparedList> sortSet = new TreeSet<ComparedList>(new Comparator<ComparedList>() {
            @Override
            public int compare(ComparedList o1, ComparedList o2) {
                int res=0;
                for (int i = 0; i < (o1.getList().size() <= o2.getList().size() ? o1.getList().size() : o2.getList().size()); i++) {
                    res = Integer.compare(o2.getList().get(i),o1.getList().get(i));
                    if (res!=0)
                        break;
                }
                return res;
            }
        });
        for (Integer[] el: arrayList) {
            sortSet.add(new ComparedList(new ArrayList<Integer>(Arrays.asList(el))));
        }
        return sortSet;
    }
}
