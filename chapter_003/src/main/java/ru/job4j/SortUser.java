package ru.job4j;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<UserSort> sort(List<UserSort> list) {
        Set<UserSort> returnSet = new TreeSet<UserSort>();
        returnSet.addAll(list);
        return returnSet;
    }
}
