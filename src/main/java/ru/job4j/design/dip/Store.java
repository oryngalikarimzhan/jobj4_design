package ru.job4j.design.dip;

public class Store {
    private Cash cash;

    public Store() {
        this.cash = new Cash();
    }

    public void sell() {
        this.cash.makeAPayment();
    }
}

class Cash {
    public void makeAPayment() {
        System.out.println("payed by cash");
    }
}

class Card {
    public void makeAPayment() {
        System.out.println("payed by card");
    }
}
