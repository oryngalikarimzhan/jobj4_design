package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        try {
            /**
             * Path
             * */
            Path path = Paths.get(argsName.get("path"));
            Path target = Paths.get(argsName.get("out"));
            String delimiter = argsName.get("delimiter");

            /**
             * filters
             * */
            List<String> filterTitle = new ArrayList<>();
            var filterScanner = new Scanner(argsName.get("filter")).useDelimiter(",");
            while (filterScanner.hasNext()) {
                filterTitle.add(filterScanner.next());
            }

            /**
             * titles or keywords
             * */

            var scannerForTitle = new Scanner(path.toFile());
            String titleLine = scannerForTitle.next();

            String[] titles = titleLine.split(delimiter);
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < titles.length; i++) {
                if (titles[i].equals(filterTitle.get(0))) {
                    index1 = i;
                } else if (titles[i].equals(filterTitle.get(1))) {
                    index2 = i;
                }
            }

            var scanner = new Scanner(path);
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            List<String[]> lineArr = lines.stream()
                    .map(s -> s.split(delimiter))
                    .collect(Collectors.toList());

            List<String> a = new ArrayList<>();
            List<String> b = new ArrayList<>();


            for (String[] strings : lineArr) {
                a.add(strings[index1]);
                b.add(strings[index2]);

            }

            String rsl = "";
            int i = 0;
            while (i != a.size()) {
                rsl = rsl + String.join(";", a.get(i), b.get(i)) + "\n";
                i++;
            }
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(target.toFile()))) {
                out.write(rsl.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
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
