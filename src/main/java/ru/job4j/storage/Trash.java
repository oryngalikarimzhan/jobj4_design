package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> trashFoods = new ArrayList<>();

    public Trash() {
    }

    public Trash(List<Food> trashFoods) {
        this.trashFoods = trashFoods;
    }

    @Override
    public void add(Food food) {
        trashFoods.add(food);
    }

    @Override
    public List<Food> getStorageFoodList() {
        return trashFoods;
    }

    @Override
    public boolean admittance(Food food) {
        return getPercentage(food) >= 100;
    }
}
