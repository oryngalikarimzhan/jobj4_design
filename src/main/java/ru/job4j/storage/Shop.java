package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> shopFoods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return admit(food) && shopFoods.add(food);
    }

    @Override
    public List<Food> getStorageFoodList() {
        List<Food> foodList = new ArrayList<>();
        foodList.addAll(shopFoods);
        return foodList;
    }

    @Override
    public boolean admit(Food food) {
        float percentage = getPercentage(food);
        return percentage >= 25 && percentage < 100 && (!(percentage >= 75) || food.setDiscount(30));
    }
}
