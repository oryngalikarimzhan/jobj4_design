package ru.job4j.design.lsp;

public class Character {

    protected int health;
    protected boolean alive;

    public Character(int health) {
        this.health = health;
        alive = true;
    }

    public void isAlive(int damage) {
        health -= damage;
        if (health < 1) {
            alive = false;
            System.out.println("WASTED");
        }
    }
}

class Deadpool extends Character {

    public Deadpool(int health) {
        super(health);
    }

    public void isAlive(int damage) {
        health -= damage;
        if (health < 1) {
            health = 100;
            System.out.println("IMBALANCE");
        }
    }
}

