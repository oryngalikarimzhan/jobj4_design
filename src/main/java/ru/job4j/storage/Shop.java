package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> shopFoods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return shopFoods.add(food);
    }

    @Override
    public List<Food> getStorageFoodList() {
        return shopFoods;
    }

    @Override
    public boolean admit(Food food) {
        float percentage = getPercentage(food);
        return percentage >= 25 && percentage < 100 && (!(percentage >= 75) || food.setDiscount(30));
    }
}
