package ru.job4j;

import java.util.*;

public class SortUser {
    public Set<UserSort> sort(List<UserSort> list) {
        Set<UserSort> returnSet = new TreeSet<UserSort>(list);
      //  returnSet.addAll(list);
        return returnSet;
    }

    public List<UserSort> sortNameLength(List<UserSort> list) {
        List<UserSort> returnList = new ArrayList<UserSort>(list);
        returnList.sort(new Comparator<UserSort>() {
            @Override
            public int compare(UserSort o1, UserSort o2) {
                return Integer.compare(o2.getName().length(), o1.getName().length());
            }
        });
        return returnList;
    };

    public List<UserSort> sortByAllFields(List<UserSort> list) {
        List<UserSort> returnList = new ArrayList<UserSort>(list);
        returnList.sort(new Comparator<UserSort>() {
            @Override
            public int compare(UserSort o1, UserSort o2) {
                int sortName = o1.getName().compareTo(o2.getName());
                return sortName!=0 ? sortName : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return returnList;
    }

}
