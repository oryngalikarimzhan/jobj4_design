package ru.job4j.storage;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void test1() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(
                List.of(
                        warehouse,
                        shop,
                        trash
                )
        );
        Food food = new Food("d", LocalDate.now().plusDays(100), LocalDate.now().minusDays(30), 120);
        controlQuality.checkFoods(
                List.of(
                    new Food("a", LocalDate.now().plusDays(10), LocalDate.now().minusDays(30), 100),
                    new Food("b", LocalDate.now().minusDays(5), LocalDate.now().minusDays(30), 110),
                    new Food("c", LocalDate.now().plusDays(30), LocalDate.now().minusDays(30), 110),
                    food
                )
        );
        assertEquals(food, warehouse.getFoodList().get(0));
    }

    @Test
    public void test2() {
        Food food = new Food("b", LocalDate.now().minusDays(5), LocalDate.now().minusDays(30), 110);
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(
                List.of(
                    warehouse,
                    shop,
                    trash
                )
        );
        controlQuality.checkFoods(
                List.of(
                        new Food("a", LocalDate.now().plusDays(10), LocalDate.now().minusDays(30), 100),
                        food,
                        new Food("c", LocalDate.now().plusDays(30), LocalDate.now().minusDays(30), 110),
                        new Food("d", LocalDate.now().plusDays(100), LocalDate.now().minusDays(30), 120)
                )
        );
        assertEquals(food, trash.getFoodList().get(0));
    }

    @Test
    public void test3() {
        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(
                List.of(
                    warehouse,
                    shop,
                    trash
                )
        );
        Food food1 = new Food("a", LocalDate.now().plusDays(10), LocalDate.now().minusDays(30), 100);
        Food food2 = new Food("c", LocalDate.now().plusDays(30), LocalDate.now().minusDays(30), 110);
        controlQuality.checkFoods(
                List.of(
                        food1,
                        new Food("b", LocalDate.now().minusDays(5), LocalDate.now().minusDays(30), 110),
                        food2,
                        new Food("d", LocalDate.now().plusDays(100), LocalDate.now().minusDays(30), 120)
                )
        );
        assertEquals(List.of(food1, food2), shop.getFoodList());
    }
}