package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void checkFoods(List<Food> foods) {
        for (Food food : foods) {
            for (Storage storage : this.storage) {
                if (storage.admit(food)) {
                    storage.add(food);
                    break;
                }
            }
        }
    }
}
