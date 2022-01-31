package ru.job4j.menu.actions;

import java.util.Scanner;

public class MinusAction implements Action {
    @Override
    public void act() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(a - b);
    }
}
