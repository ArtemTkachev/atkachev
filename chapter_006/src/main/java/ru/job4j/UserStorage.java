package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Set;
import java.util.TreeSet;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Set<User> userSet;

    public UserStorage() {
        userSet = new TreeSet<>();
    }

    public synchronized boolean add(User user) {
        return userSet.add(user);
    }

    public synchronized boolean update(User user) {
        boolean ret = false;
        for (User u : userSet) {
            if (u.getId() == user.getId()) {
                u.setAmount(user.getAmount());
                ret = true;
            }
        }
        return ret;
    }

    public synchronized boolean delete(User user) {
        return userSet.remove(user);
    }

    public User getById(int id) {
        User user = null;
        for (User u : userSet) {
            if (u.getId() == id) {
                user = u;
            }
        }
        return user;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        User userFrom = null;
        User userTo = null;
        for (User u : userSet) {
            if (u.getId() == fromId) {
                userFrom = u;
            }
            if (u.getId() == toId) {
                userTo = u;
            }
        }
        if (userFrom != null && userTo != null && userFrom.getAmount() >= amount) {
            userFrom.setAmount(userFrom.getAmount() - amount);
            userTo.setAmount(userTo.getAmount() + amount);
        }
    }
}

