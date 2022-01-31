package ru.job4j.menu;

import ru.job4j.menu.actions.Action;

public interface MenuItem {
    boolean add(String parentName, String childName, Action action);
    Action select(String itemName);
}
