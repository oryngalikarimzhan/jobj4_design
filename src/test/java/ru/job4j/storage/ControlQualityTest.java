package ru.job4j.storage;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void test1() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop(30);
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(
                warehouse,
                shop,
                trash
        ));
        Food food = new Food(
                "d",
                LocalDate.of(2022, 4, 10),
                LocalDate.of(2022, 1, 1),
                120
        );
        controlQuality.checkup(List.of(
                new Food(
                        "a",
                        LocalDate.of(2022, 1, 30),
                        LocalDate.of(2022, 1, 1),
                        100
                ),
                new Food(
                        "b",
                        LocalDate.of(2022, 1, 22),
                        LocalDate.of(2022, 1, 1),
                        110
                ),
                new Food(
                        "c",
                        LocalDate.of(2022, 2, 25),
                        LocalDate.of(2022, 1, 1),
                        110
                ),
                food
        ));
        assertEquals(warehouse.getStorageFoodList().get(0), food);
    }

    @Test
    public void test2() {
        Food food = new Food(
                "d",
                LocalDate.of(2022, 4, 10),
                LocalDate.of(2022, 1, 1),
                120
        );
        Storage warehouse = new Warehouse(new ArrayList<>(Arrays.asList(
                new Food(
                        "a",
                        LocalDate.of(2022, 1, 30),
                        LocalDate.of(2022, 1, 1),
                        100
                ),
                new Food(
                        "b",
                        LocalDate.of(2022, 1, 22),
                        LocalDate.of(2022, 1, 1),
                        110
                ),
                new Food(
                        "c",
                        LocalDate.of(2022, 2, 25),
                        LocalDate.of(2022, 1, 1),
                        110
                ),
                food
        )));
        Storage shop = new Shop(30);
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        controlQuality.checkup();
        assertEquals(food, warehouse.getStorageFoodList().get(0));
    }

    @Test
    public void test3() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop(30);
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(
                warehouse,
                shop,
                trash
        ));
        Food food1 = new Food(
                "a",
                LocalDate.of(2022, 1, 30),
                LocalDate.of(2022, 1, 1),
                100
        );
        Food food2 = new Food(
                "c",
                LocalDate.of(2022, 2, 25),
                LocalDate.of(2022, 1, 1),
                110
        );
        controlQuality.checkup(List.of(
                food1,
                new Food(
                        "b",
                        LocalDate.of(2022, 1, 22),
                        LocalDate.of(2022, 1, 1),
                        110
                ),
                food2,
                new Food(
                        "d",
                        LocalDate.of(2022, 4, 10),
                        LocalDate.of(2022, 1, 1),
                        120
        )));
        assertEquals(List.of(food1, food2), shop.getStorageFoodList());
    }

    @Test
    public void test4() {
        Food food1 = new Food(
                "a",
                LocalDate.of(2022, 1, 30),
                LocalDate.of(2022, 1, 1),
                100
        );
        Food food2 = new Food(
                "c",
                LocalDate.of(2022, 2, 25),
                LocalDate.of(2022, 1, 1),
                110
        );
        Storage shop = new Shop(30, new ArrayList<>(Arrays.asList(
                food1,
                new Food(
                        "b",
                        LocalDate.of(2022, 1, 22),
                        LocalDate.of(2022, 1, 1),
                        110
                ),
                food2,
                new Food(
                        "d",
                        LocalDate.of(2022, 4, 10),
                        LocalDate.of(2022, 1, 1),
                        120
                )
        )));
        Storage warehouse = new Warehouse();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        controlQuality.checkup();
        assertEquals(List.of(food1, food2), shop.getStorageFoodList());
    }
}