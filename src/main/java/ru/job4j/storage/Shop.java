package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> shopFoods = new ArrayList<>();
    private int discount;

    public Shop(int discount, List<Food> shopFoods) {
        this.shopFoods = shopFoods;
        this.discount = discount;
    }

    public Shop(int discount) {
        this.discount = discount;
    }

    @Override
    public void add(Food food) {
        shopFoods.add(food);
    }

    @Override
    public List<Food> getStorageFoodList() {
        return shopFoods;
    }

    @Override
    public boolean admittance(Food food) {
        float percentage = getPercentage(food);
        return percentage >= 25 && percentage < 100 && (!(percentage >= 75) || food.setDiscount(discount));
    }
}
