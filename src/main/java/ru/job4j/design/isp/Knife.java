package ru.job4j.design.isp;

public class Knife implements Weapon {
    @Override
    public void attack() {
        System.out.println("stab");
    }

    @Override
    public void reload() {
        throw new UnsupportedOperationException();
    }
}
