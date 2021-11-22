package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {

        Path path = Paths.get(argsName.get("path"));
        Path target = Paths.get(argsName.get("out"));
        String delimiter = argsName.get("delimiter");

        List<String> filterList = new ArrayList<>();
        try (var filterScanner = new Scanner(argsName.get("filter")).useDelimiter(",")) {
            while (filterScanner.hasNext()) {
                filterList.add(filterScanner.next());
            }
        }

        List<String> titlesList = new ArrayList<>();
        try (var titleLineScanner = new Scanner(path)) {
            if (titleLineScanner.hasNextLine()) {
                String titlesLine = titleLineScanner.nextLine();
                var titlesScanner = new Scanner(titlesLine).useDelimiter(delimiter);
                while (titlesScanner.hasNext()) {
                    titlesList.add(titlesScanner.next());
                }
            }
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String title : titlesList) {
            map.put(title, new ArrayList<>());
        }

        int counter = 0;
        try (var scanner = new Scanner(path).useDelimiter(delimiter)) {
            while (scanner.hasNext()) {
                counter++;
                for (String title : titlesList) {
                    map.get(title).add(scanner.next());
                }
            }
        }

        StringBuilder rsl = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            List<String> strings = new ArrayList<>();
            for (String filter : filterList) {
                strings.add(map.get(filter).get(i));
            }
            rsl.append(String.join(";", strings)).append("\n");
        }

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(target.toFile()))) {
            out.write(rsl.toString().getBytes());
        }
    }

    private static String[] validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Root folder is null");
        }
        Path start = Paths.get(ArgsName.of(args).get("path"));
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", start.toFile().getAbsoluteFile()));
        }
        if (!start.toFile().isFile()) {
            throw new IllegalArgumentException(String.format("Not file %s", start.toFile().getAbsoluteFile()));
        }
        return args;
    }

    public static void main(String[] args) throws Exception {
        String[] arg = validate(args);
        ArgsName argsName = ArgsName.of(arg);
        handle(argsName);
    }
}
