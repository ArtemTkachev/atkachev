package ru.job4j;

import java.util.Calendar;

public class UserM {
    private String name;
    private int children;
    private Calendar birthday;

    public UserM(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserM userM = (UserM) o;

        if (children != userM.children) return false;
        if (name != null ? !name.equals(userM.name) : userM.name != null) return false;
        return birthday != null ? birthday.equals(userM.birthday) : userM.birthday == null;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }
}
