package ru.job4j;

import java.util.*;

public class TwoSameObjects {

    public void createTO() {
        Calendar calendar = new GregorianCalendar();
        UserM user1 = new UserM("Игорь",0, calendar);
        UserM user2 = new UserM("Игорь",0, calendar);
        Map<UserM,Object> userObjectMap = new HashMap<>();
        userObjectMap.put(user1,1);
        userObjectMap.put(user2,2);
        System.out.print(userObjectMap);
    }
}
