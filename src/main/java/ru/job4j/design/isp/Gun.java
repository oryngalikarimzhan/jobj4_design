package ru.job4j.design.isp;

public class Gun implements Weapon {
    @Override
    public void attack() {
        System.out.println("Shoot");
    }

    @Override
    public void reload() {
        System.out.println("Reload");
    }
}
