package ru.job4j.storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Storage {

    boolean add(Food food);

    List<Food> getStorageFoodList();

    boolean admit(Food food);

    default float getPercentage(Food food) {
        var create = food.getCreateDate();
        var expirationTerm = (float) ChronoUnit.DAYS.between(create, food.getExpiryDate());
        var actualTerm = (float) ChronoUnit.DAYS.between(create, LocalDate.now());
        return actualTerm / expirationTerm * 100;
    }
}
