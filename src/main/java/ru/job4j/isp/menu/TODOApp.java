package ru.job4j.isp.menu;

import java.util.Scanner;

public class TODOApp {
    public static void main(String[] args) {
        ActionDelegate justDoItAction = new SimpleActionDelegate();

        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", justDoItAction);
        menu.add(Menu.ROOT, "Покормить собаку", justDoItAction);
        menu.add("Сходить в магазин", "Купить продукты", justDoItAction);
        menu.add("Купить продукты", "Купить хлеб", justDoItAction);
        menu.add("Купить продукты", "Купить молоко", justDoItAction);
        init(menu);

    }

    private static void init(Menu menu) {
        Scanner in = new Scanner(System.in);
        SimpleMenuPrinter simpleMenuPrinter = new SimpleMenuPrinter();
        while (true) {
            simpleMenuPrinter.print(menu);
            String str = in.nextLine();
            if (str.equals("exit")) {
                break;
            }
            if (menu.select(str).isPresent()) {
                menu.select(str).get().getActionDelegate().delegate();
            }
        }
    }
}
