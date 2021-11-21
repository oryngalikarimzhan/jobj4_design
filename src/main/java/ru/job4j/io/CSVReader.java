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

        String fil1 = "";
        String fil2 = "";

        try (var filterScanner = new Scanner(argsName.get("filter")).useDelimiter(",")) {
            while (filterScanner.hasNext()) {
                fil1 = filterScanner.next();
                fil2 = filterScanner.next();
            }
        }

        String n = "";
        String a = "";
        String l = "";
        String e = "";

        try (var titleScanner = new Scanner(path).useDelimiter(delimiter)) {
            if (titleScanner.hasNextLine()) {
                 n = titleScanner.next();
                 a = titleScanner.next();
                 l = titleScanner.next();
                 e = titleScanner.next();
            }
        }

        Map<String, List<String>> map = new HashMap<>();
        map.put(n, new ArrayList<>());
        map.put(a, new ArrayList<>());
        map.put(l, new ArrayList<>());
        map.put(e, new ArrayList<>());


        try (var scanner = new Scanner(path).useDelimiter(delimiter)) {
            while (scanner.hasNext()) {
                map.get(n).add(scanner.next());
                map.get(a).add(scanner.next());
                map.get(l).add(scanner.next());
                map.get(e).add(scanner.next());
            }
        }


        StringBuilder rsl = new StringBuilder();
        int i = 0;
        while (i < map.size()) {
            rsl.append(map.get(fil1).get(i)).append(";").append(map.get(fil2).get(i)).append("\n");
            i++;
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
