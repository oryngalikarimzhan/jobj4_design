package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar target/dir.jar . ");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("size : %s%n", file.getTotalSpace());
        System.out.printf("%-30s %10s %n", "Name", "Size");

        for (File subFile : file.listFiles()) {
            System.out.printf("%-30s %10s %n", subFile.getName(), subFile.getAbsoluteFile().length());
        }
    }
}