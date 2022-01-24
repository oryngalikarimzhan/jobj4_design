package ru.job4j.parking;

public class Transport {
    private String name;
    private int size;
    private String transportNumber;
    private String ownerName;

    public Transport(String name, int size, String transportNumber, String ownerName) {
        this.name = name;
        this.size = size;
        this.transportNumber = transportNumber;
        this.ownerName = ownerName;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Transport{"
                + "name='" + name + '\''
                + ", size=" + size
                + ", transportNumber='" + transportNumber + '\''
                + ", ownerName='" + ownerName + '\''
                + '}';
    }
}
