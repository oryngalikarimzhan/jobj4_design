package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Storage> storage;
    private List<Food> allFoods = new ArrayList<>();

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void checkup() {
        prepareCheckup();
        checkFoods();
    }

    public void checkup(List<Food> foods) {
        prepareCheckup();
        allFoods.addAll(foods);
        checkFoods();
    }

    private void prepareCheckup() {
        storage.forEach(storage -> allFoods.addAll(storage.getStorageFoodList()));
        storage.forEach(st -> st.getStorageFoodList().clear());
    }

    private void checkFoods() {
        for (Food food : allFoods) {
            for (Storage storage : this.storage) {
                if (storage.admittance(food)) {
                    storage.add(food);
                }
            }
        }
    }
}
