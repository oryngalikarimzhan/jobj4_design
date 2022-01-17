package ru.job4j.ocp;

public class Phone {
    private String type;
    private String OS;

    public Phone(String type, String OS) {
        this.type = type;
        this.OS = OS;
    }

    public void use() {
        if (this.type == "iphone") {
            System.out.println("use appstore because " + this.OS);
        } else if (this.type == "samsung") {
            System.out.println("use playmarket because " + this.OS);
        }
    }

    public static void main(String[] args) {
        User user = new User("Vlad", new Phone("iphone", "IOS"));
        user.use();
    }
}

class User {
    private String name;
    Phone phone;

    public User(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public void use() {
        this.phone.use();
    }
}
