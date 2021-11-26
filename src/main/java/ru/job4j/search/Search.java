package ru.job4j.search;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    public static void main(String[] args) throws IOException {
        String[] searchingArgs = validate(args);
        ArgumentsName argsName = ArgumentsName.of(searchingArgs);
        search(argsName);
    }

    private static String[] validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(
                    "Should be 4 arguments. Example -> java -jar target/find.jar -d=. -n=*.txt -t=mask -o=log.txt \n"
                            + "\"-d\" - main directory, where the program starts searching\n"
                            + "\"-n\" - file name, mask, or regular expression\n"
                            + "\"-t\" - searching type: 'mask' search by mask,\n"
                            + "         'name' search by full name of the file,\n"
                            + "         'regex' search by regular expression\n"
                            + "\"-o\" - file, where the result will be written\n");
        }
        Path start = Paths.get(ArgumentsName.of(args).get("d"));
        String searchingType = ArgumentsName.of(args).get("t");
        if (!"name".equals(searchingType) && !"mask".equals(searchingType) && !"regex".equals(searchingType)) {
            throw new IllegalArgumentException(
                    "\"-t\" - searching type can take only 3 defined options\n"
                    + "Options ->  'mask', 'name', 'regex'");
        }
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", start.toFile().getAbsoluteFile()));
        }
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", start.toFile().getAbsoluteFile()));
        }
        return args;
    }

    public static void search(ArgumentsName argsName) throws IOException {
        Path root = Paths.get(argsName.get("d"));
        Path target = Paths.get(argsName.get("o"));
        String searchingWord = argsName.get("n");
        String searchingType = argsName.get("t");

        SearchFiles searcher = new SearchFiles(predicate(searchingWord, searchingType));
        Files.walkFileTree(root, searcher);
        writeLog(target, searcher.getPaths());
    }

    public static Predicate<Path> predicate(String searchingWord, String searchingType) {
        Predicate<Path> predictor = null;
        if ("name".equals(searchingType)) {
            predictor = p -> p.toFile().getName().equals(searchingWord);
        } else if ("mask".equals(searchingType)) {
            String mask = searchingWord.replaceAll("\\*", ".\\*");
            String finalMask = mask.replaceAll("\\?", ".\\?");
            predictor = p -> p.toFile().getName().matches(finalMask);
        } else if ("regex".equals(searchingType)) {
            predictor = p -> p.toFile().getName().matches(searchingWord);
        }
        return predictor;
    }

    public static void writeLog(Path target, List<Path> pathList) {
        try (PrintWriter pr = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path path : pathList) {
                pr.println(path.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}