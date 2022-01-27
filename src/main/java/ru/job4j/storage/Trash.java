package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> trashFoods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return trashFoods.add(food);
    }

    @Override
    public List<Food> getFoodList() {
        return new ArrayList<>(trashFoods);
    }

    @Override
    public boolean admit(Food food) {
        return getPercentage(food) >= 100;
    }

    @Override
    public void clear() {
        trashFoods.clear();
    }
}
