package ru.job4j;

import java.util.ArrayList;

public class ComparedList implements Comparable<ComparedList> {
    private ArrayList<Integer> list;
    public ComparedList(ArrayList<Integer> list) {
        this.list = list;
    }
    public ArrayList<Integer> getList() {
        return list;
    }
    @Override
    public int compareTo(ComparedList o) {
        int res=0;
        for (int i = 0; i < (this.list.size() <= o.list.size() ? this.list.size() : o.list.size()); i++) {
            res = Integer.compare(this.list.get(i),o.list.get(i));
            if (res!=0)
                break;
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComparedList that = (ComparedList) o;

        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}
