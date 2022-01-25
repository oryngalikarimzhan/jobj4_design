package ru.job4j.design.isp;

public class Chess implements Game {
    @Override
    public void changeTurn() {
        System.out.println("Players change turn");
    }

    @Override
    public void find() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void attack() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void block() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {
        System.out.println("Player moves");
    }
}
