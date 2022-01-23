package ru.job4j.design.srp;

public class Account {
    private Person person;
    private int balance;
    private int score;


    public Account(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getScore() {
        return score;
    }
}

