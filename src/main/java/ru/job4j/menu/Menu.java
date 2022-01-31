package ru.job4j.menu;

import ru.job4j.menu.actions.*;

import java.util.*;
import java.util.function.Predicate;

public class Menu implements MenuItem, Printable {

    private final Item rootItem;

    public Menu(String rootItemName, Action action) {
        this.rootItem = new Item(rootItemName, action, null);
    }

    @Override
    public boolean add(String parentName, String childName, Action action) {
        boolean rsl = false;
        Optional<Item> findParentItem = findBy(parentName);
        Optional<Item> findChildItem = findBy(childName);
        if (findParentItem.isPresent()
                && findChildItem.isEmpty()) {
            Item childItem = new Item(childName, action, findParentItem.get());
            findParentItem.get().children.add(childItem);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Action select(String itemName) {
        return findBy(itemName).get().action;
    }

    @Override
    public void print() {
        printOut(this.rootItem);
        System.out.println("exit");
    }

    private void printOut(Item item) {
        if (item == this.rootItem) {
            System.out.println(item.name);
        }
        int count = countParents(item);
        if (item.children.size() != 0) {
            for (Item childItem : item.children) {
                for (int i = 0; i != count; i++) {
                    System.out.print("---");
                }
                System.out.println(childItem.name);
                printOut(childItem);
            }
        }
    }

    private int countParents(Item item) {
        int count = 1;
        while (item.parent != null) {
            item = item.parent;
            count++;
        }
        return count;
    }

    public Optional<Item> findBy(String itemName) {
        return findByPredicate(item -> item.name.equals(itemName));
    }

    private Optional<Item> findByPredicate(Predicate<Item> condition) {
        Optional<Item> rsl = Optional.empty();
        Queue<Item> data = new LinkedList<>();
        data.offer(this.rootItem);
        while (!data.isEmpty()) {
            Item item  = data.poll();
            if (condition.test(item)) {
                rsl = Optional.of(item);
                break;
            }
            data.addAll(item.children);
        }
        return rsl;
    }

    public static void init(Menu menu) {
        Scanner in = new Scanner(System.in);
        while (true) {
            menu.print();
            String str = in.nextLine();
            if (str.equals("exit")) {
                break;
            }
            menu.select(str).act();
        }
    }


    public static void main(String[] args) {
        Menu menu = new Menu("menu", new SimpleAction());
        menu.add("menu", "plus2", new PlusAction());
        menu.add("plus2", "plus3", new Plus3ElementsAction());
        menu.add("plus2", "plus4", new Plus4ElementsAction());
        menu.add("menu", "minus2", new MinusAction());
        init(menu);
    }
}


