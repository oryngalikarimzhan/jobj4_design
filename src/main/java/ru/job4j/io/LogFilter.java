package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> log404 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            log404 = in.lines()
                    .filter(x -> "404".equals(x.split(" ")[x.split(" ").length - 2]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return log404;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
           log.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("./data/log.txt");
        save(log, "./data/404.txt");
    }
}