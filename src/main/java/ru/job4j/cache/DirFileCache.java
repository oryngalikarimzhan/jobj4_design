package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path filePath = Path.of(cachingDir, key);
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Oops";
    }
}