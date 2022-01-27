package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> warehouseFoods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return warehouseFoods.add(food);
    }

    @Override
    public List<Food> getFoodList() {
        return new ArrayList<>(warehouseFoods);
    }

    @Override
    public boolean admit(Food food) {
        return getPercentage(food) < 25;
    }

    @Override
    public void clear() {
        warehouseFoods.clear();
    }
}
