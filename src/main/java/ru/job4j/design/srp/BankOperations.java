package ru.job4j.design.srp;

public interface BankOperations {
    public boolean sendMoney(Account sender, Account receiver, int amount);
    public boolean giveCreditCard(Account client, int amount);
}
