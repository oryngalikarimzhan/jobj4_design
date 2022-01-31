package ru.job4j.menu.actions;

public class SimpleAction implements Action {
    @Override
    public void act() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Select section");
    }
}
