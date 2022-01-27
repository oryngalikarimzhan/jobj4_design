package ru.job4j.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void checkFoods(List<Food> foods) {
        for (Food food : foods) {
            for (Storage storage : this.storages) {
                if (storage.admit(food)) {
                    storage.add(food);
                    break;
                }
            }
        }
    }

    private List<Food> collect() {
        List<Food> allFoods = new ArrayList<>();
        storages.forEach(storage -> allFoods.addAll(storage.getStorageFoodList()));
        storages.forEach(st -> st.getStorageFoodList().clear());
        return allFoods;
    }

    public void resort() {
        checkFoods(collect());
    }

    public static void main(String[] args) {
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
        controlQuality.resort();
        System.out.println(warehouse.getStorageFoodList());
        System.out.println(shop.getStorageFoodList());
        System.out.println(trash.getStorageFoodList());
    }
}


