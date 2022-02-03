package ru.job4j.isp.menu;

public class SimpleActionDelegate implements ActionDelegate {
    @Override
    public void delegate() {
        System.out.println("Just do it");
    }
}
