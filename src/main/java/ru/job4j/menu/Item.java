package ru.job4j.menu;

import ru.job4j.menu.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class Item {
    final Item parent;
    final String name;
    final List<Item> children = new ArrayList<>();
    final Action action;

    public Item(String name, Action action, Item parent) {
        this.name = name;
        this.action = action;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", action=" + action
                + '}';
    }
}
