package ru.job4j.parking;

public class Car extends Transport {

    public static final int SIZE = 1;

    public Car(String name, int size, String transportNumber, String ownerName) {
        super(name, SIZE, transportNumber, ownerName);
    }
}
