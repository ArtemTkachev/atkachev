package ru.job4j;

public class UserSort implements Comparable<UserSort> {
    private String name;
    private int age;

    public UserSort(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(UserSort o) {
      //  return this.age < o.age ? 1 : -1;
        int res = Integer.compare(o.age,this.age);
        return res!=0 ? res : this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSort userSort = (UserSort) o;

        if (age != userSort.age) return false;
        return name != null ? name.equals(userSort.name) : userSort.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}

