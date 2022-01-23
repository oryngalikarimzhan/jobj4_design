package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> warehouseFoods = new ArrayList<>();

    public Warehouse() {
    }

    public Warehouse(List<Food> warehouseFoods) {
        this.warehouseFoods = warehouseFoods;
    }

    @Override
    public void add(Food food) {
        warehouseFoods.add(food);
    }

    @Override
    public List<Food> getStorageFoodList() {
        return warehouseFoods;
    }

    @Override
    public boolean admittance(Food food) {
        return getPercentage(food) < 25;
    }
}
