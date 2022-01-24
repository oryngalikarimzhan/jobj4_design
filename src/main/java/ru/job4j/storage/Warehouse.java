package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> warehouseFoods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return admit(food) && warehouseFoods.add(food);
    }

    @Override
    public List<Food> getStorageFoodList() {
        List<Food> foodList = new ArrayList<>();
        foodList.addAll(warehouseFoods);
        return foodList;
    }

    @Override
    public boolean admit(Food food) {
        return getPercentage(food) < 25;
    }
}
