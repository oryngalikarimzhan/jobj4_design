package ru.job4j.parking;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleParkingTest {

    @Test
    public void whenFull() {
        SimpleParking simpleParking = new SimpleParking(2, 1);
        Truck truck1 = new Truck("truck1", 2, "001", "vasya");
        Car car1 = new Car("car1", Car.SIZE, "002", "kostya");
        Car car2 = new Car("car2", Car.SIZE, "003", "petya");
        simpleParking.add(truck1);
        simpleParking.add(car1);
        simpleParking.add(car2);
        assertFalse(simpleParking.add(new Car("car3", Car.SIZE, "004", "misha")));
    }

    @Test
    public void when2TrucksOccupies2CarSpacesAnd1TruckSpaceThenFull() {
        SimpleParking simpleParking = new SimpleParking(2, 1);
        Truck truck1 = new Truck("truck1", 2, "001", "vasya");
        Truck truck2 = new Truck("truck2", 2, "005", "tolya");
        simpleParking.add(truck1);
        simpleParking.add(truck2);
        assertFalse(simpleParking.add(new Car("car3", Car.SIZE, "004", "misha")));
        assertThat(simpleParking.getTransports()[0], is(truck2));
        assertThat(simpleParking.getTransports()[1], is(truck2));
        assertThat(simpleParking.getTransports()[2], is(truck1));
    }
}