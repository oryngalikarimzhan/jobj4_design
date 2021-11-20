package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        String[] searchingArgs = validate(args);
        Path start = Paths.get(searchingArgs[0]);
        search(start, p -> !p.toFile().getName().endsWith(searchingArgs[1]))
                .forEach(System.out::println);
    }

    private static String[] validate(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar target/search.jar . java");
        }
        Path start = Paths.get(args[0]);
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", start.toFile().getAbsoluteFile()));
        }
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toFile().getAbsoluteFile()));
        }
        return args;
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}