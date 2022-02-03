package ru.job4j.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(SimpleMenuPrinter::printOut);
        System.out.println("exit");
    }

    private static void printOut(Menu.MenuItemInfo menuItemInfo) {
        addIndents(menuItemInfo);
        System.out.println(menuItemInfo.getNumber() + menuItemInfo.getName());
    }

    private static void addIndents(Menu.MenuItemInfo menuItemInfo) {
        int counter = menuItemInfo.getNumber().split("[.]").length;
        if (counter > 1) {
            for (int i = 1; i != counter; i++) {
                System.out.print("---");
            }
        }
    }
}
