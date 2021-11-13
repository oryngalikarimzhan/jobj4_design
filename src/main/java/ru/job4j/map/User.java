package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

//    public static void main(String[] args) {
//        User user1 = new User("Bob", 2,
//                new GregorianCalendar(1996, Calendar.MARCH, 9));
//        User user2 = new User("Bob", 2,
//                new GregorianCalendar(1996, Calendar.MARCH, 9));
//
//        Map<User, Object> users = new HashMap<>();
//        users.put(user1, new Object());
//        users.put(user2, new Object());
//
//        for (Map.Entry<User, Object> user : users.entrySet()) {
//            System.out.println(user);
//        }
//    }
}
