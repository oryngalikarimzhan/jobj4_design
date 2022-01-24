package ru.job4j.parking;

public class SimpleParking implements Parking {
    Transport[] transports;
    private final int carPlaces;
    private final int truckPlaces;
    private int countCar = 0;
    private int countTruck = 0;



    public SimpleParking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
        this.transports = new Transport[carPlaces + truckPlaces];
    }

    @Override
    public Transport[] showAll() {
        return transports;
    }

    @Override
    public boolean add(Transport transport) {
        int transportSize = transport.getSize();
        boolean result = false;
        if (transportSize == 1) {
            if (countCar < carPlaces) {
                transports[countCar] = transport;
                countCar++;
                result = true;
            }
        } else if (transportSize > 1) {
            if (countTruck < truckPlaces) {
                transports[carPlaces + countTruck] = transport;
                countTruck++;
                result = true;
            } else if (carPlaces - countCar >= transportSize) {
                boolean test = false;
                for (int i = 0; i != carPlaces; i++) {
                    int counter = 0;
                    for (int x = 0; x < transportSize; x++) {
                        if (transports[i + x] == null) {
                            counter++;
                            test = true;
                        } else {
                            test = false;
                        }
                    }
                    if (counter == transportSize) {
                        break;
                    }
                }
                if (test) {
                    for (int i = 0; i != transportSize; i++) {
                        transports[countCar + i] = transport;
                    }
                    countCar += transportSize;
                    result = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SimpleParking simpleParking = new SimpleParking(2, 1);
        System.out.println(simpleParking.add(new Truck("truck1", 2, "wf", "ewf")));
        System.out.println(simpleParking.add(new Car("car1", "efw", "fewf")));
        System.out.println(simpleParking.add(new Truck("truck2", 2, "wf", "ewf")));
        for (Transport transport : simpleParking.transports) {
            System.out.println(transport);
        }
        System.out.println(simpleParking.add(new Truck("truck3", 2, "wf", "ewf")));
    }
}
