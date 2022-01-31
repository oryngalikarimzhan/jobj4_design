package ru.job4j.menu.actions;

import java.util.Scanner;

public class Plus3ElementsAction implements Action {
    @Override
    public void act() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println(a + b + c);
    }
}
