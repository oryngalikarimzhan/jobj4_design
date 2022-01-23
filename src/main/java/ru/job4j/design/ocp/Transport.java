package ru.job4j.design.ocp;

public class Transport {
    String type;
    String engine;
    String fuel;

    public Transport(String type, String engine, String fuel) {
        this.type = type;
        this.engine = engine;
        this.fuel = fuel;
    }

    public static void main(String[] args) {
        Transport kiaRio3 = new Transport("avto", "injector", "gasoline");
        Transport bikeKama = new Transport("bike", null, null);
    }
}
