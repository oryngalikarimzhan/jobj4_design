package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> log404 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            in.lines()
                    .filter(x -> "404".equals(x.split(" ")[x.split(" ").length - 2]))
                            .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log404;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}