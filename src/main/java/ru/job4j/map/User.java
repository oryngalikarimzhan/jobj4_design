package ru.job4j.map;
import java.util.*;
public class User {
    private String name;
    private int children;
    private Calendar birthday;
    private int[] k;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31* result + Integer.hashCode(children);
        result = (31 * result) + birthday.hashCode();
        result = (31 * result) + Arrays.hashCode(k);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

}