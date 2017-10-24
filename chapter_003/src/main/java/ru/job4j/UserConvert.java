package ru.job4j;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
   public HashMap<Integer, User> process(List<User> list) {
        HashMap <Integer, User> returnProcess = new HashMap<Integer, User>();
        if (!list.isEmpty()) {
            for (int index = 0; index < list.size(); index++) {
                if (list.get(index) != null) {
                    returnProcess.put(list.get(index).getId(),list.get(index));
                }
            }
        }
        return returnProcess;
   }

}
