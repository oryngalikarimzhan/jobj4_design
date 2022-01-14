package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Emulator {
    public static void main(String[] args) {
        Path mainDir = Path.of("./cachingDir");
        DirVisit dirVisit = new DirVisit();
        new Emulator().init(mainDir, dirVisit);
    }

    private void init(Path mainDir, DirVisit dirVisit) {
        Map<String, Path> filesMap = new HashMap<>();
        DirFileCache dirFileCache = new DirFileCache(mainDir.toString());
        try {
            Files.walkFileTree(mainDir, dirVisit);
            filesMap = dirVisit.getFiles();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Not found any file");
        }
        while (true) {
            menu(filesMap);
            Scanner in = new Scanner(System.in);
            String number = String.valueOf(in.nextInt());
            if (number.equals("999")) {
                break;
            } else if (Integer.parseInt(number) < filesMap.size()) {
                String choice = filesMap.get(number).toString();
                System.out.println(dirFileCache.get(choice));
                System.out.println("----------------------------------------------");
            } else {
                System.out.println("---Enter again---");
            }
        }
    }
    private void menu(Map<String, Path> filesMap) {
        System.out.println("Please choose the file by entering the relevant number");
        for (Map.Entry<String, Path> file : filesMap.entrySet()) {
            System.out.println(file.getKey() + " - " + file.getValue());
        }
        System.out.println("999 - Close");
    }
}



class DirVisit extends SimpleFileVisitor<Path> {
    private int count = 0;
    private Map<String, Path> files = new HashMap<>();

    public Map<String, Path> getFiles() {
        return files;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        files.put(String.valueOf(count++), file.getFileName());
        return super.visitFile(file, attrs);
    }
}
