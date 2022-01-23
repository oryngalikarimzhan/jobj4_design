package ru.job4j.design.srp;

public class Checker {
    private boolean result;

    public Checker(Account client, int amount) {
        result = client.getScore() > 300 && client.getBalance() >= amount;
    }

    public boolean getResult() {
        return result;
    }
}
