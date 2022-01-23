package ru.job4j.design.srp;

public class SimpleBankOperations implements BankOperations {
    @Override
    public boolean sendMoney(Account sender, Account receiver, int amount) {
        boolean result = false;
        if (sender.getBalance() >= amount) {
            receiver.setBalance(amount);
            result = true;
        }
        return result;
    }

    @Override
    public boolean giveCreditCard(Account client, int amount) {
        boolean result = false;
        Checker checker = new Checker(client, amount);
        if (checker.getResult()) {
            CreditCard creditCard = new CreditCard(client, amount);
            result = true;
        }
        return result;
    }
}
