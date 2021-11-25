package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Scanner;

public class ResultFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        try (FileOutputStream out = new FileOutputStream("./data/result.txt")) {
            for (int row = 0; row < size; row++) {
                for (int cell = 0; cell < size; cell++) {
                    out.write(((row + 1) * (cell + 1) + " ").getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
