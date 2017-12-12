package ru.job4j;

import java.util.*;

public class TwoSameObjects {

    public void createTO() {
        UserM user1 = new UserM("Игорь",0, new GregorianCalendar());
        UserM user2 = new UserM("Игорь",0, new GregorianCalendar());
        Map<UserM,Object> userObjectMap = new HashMap<>();
        userObjectMap.put(user1,1);
        userObjectMap.put(user2,2);
        System.out.print(userObjectMap);
    }
}
