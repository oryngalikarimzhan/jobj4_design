package ru.job4j.parking;

public class SimpleParking implements Parking {
    private Transport[] transports;
    private Transport[] trucks;
    private final int carSpaces;
    private final int truckSpaces;
    private int occupiedCarSpaces = 0;
    private int occupiedTruckSpaces = 0;
    private int transportSize;

    public SimpleParking(int carSpaces, int truckSpaces) {
        this.carSpaces = carSpaces;
        this.truckSpaces = truckSpaces;
        this.transports = new Transport[carSpaces];
        this.trucks = new Truck[truckSpaces];
    }

    @Override
    public Transport[] getTransports() {
        Transport[] allTransport = new Transport[carSpaces + truckSpaces];
        System.arraycopy(transports, 0, allTransport, 0, carSpaces);
        System.arraycopy(trucks, 0, allTransport, carSpaces, truckSpaces);
        return allTransport;
    }

    @Override
    public boolean add(Transport transport) {
        this.transportSize = transport.getSize();
        boolean result = false;
        if (transportSize == 1) {
            result = addCar(transport);
        } else if (transportSize > 1) {
            result = addTruck(transport);
        }
        return result;
    }

    private boolean addCar(Transport transport) {
        if (freeCarSpaces() > 0) {
            transports[occupiedCarSpaces++] = transport;
            return true;
        }
        return false;
    }

    private boolean addTruck(Transport transport) {
        if (freeTruckSpaces() > 0) {
            trucks[occupiedTruckSpaces++] = transport;
            return true;
        } else if (freeCarSpaces() >= transportSize) {
            if (canTruckFitToCarSpace()) {
                for (int i = 0; i != transportSize; i++) {
                    transports[occupiedCarSpaces++] = transport;
                }
                return true;
            }
        }
        return false;
    }

    private int freeCarSpaces() {
        return carSpaces - occupiedCarSpaces;
    }

    private int freeTruckSpaces() {
        return truckSpaces - occupiedTruckSpaces;
    }

    private boolean canTruckFitToCarSpace() {
        boolean sizeConfirm = false;
        for (int i = occupiedCarSpaces; i != carSpaces; i++) {
            int sizeChecker = 0;
            for (int x = 0; x < transportSize; x++) {
                if (transports[i + x] == null) {
                    sizeChecker++;
                    sizeConfirm = true;
                } else {
                    sizeConfirm = false;
                }
            }
            if (sizeChecker == transportSize) {
                break;
            }
        }
        return sizeConfirm;
    }
}
