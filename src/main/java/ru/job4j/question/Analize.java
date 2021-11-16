package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int addedCount = 0;
        int changedCount = 0;
        int deletedCount = 0;

        Map<Integer, String> previousMap = new HashMap<>();
        Map<Integer, String> currentMap = new HashMap<>();

        for (User prev : previous) {
            previousMap.put(prev.getId(), prev.getName());
        }

        for (User curr : current) {
            currentMap.put(curr.getId(), curr.getName());
        }

        for (Integer key : currentMap.keySet()) {
            if (!previousMap.containsKey(key)) {
                addedCount++;
            }
        }

        for (Integer key : previousMap.keySet()) {
            if (!currentMap.containsKey(key)) {
                deletedCount++;
            } else if (!currentMap.get(key).equals(previousMap.get(key))) {
                changedCount++;
            }
        }
        return new Info(addedCount, changedCount, deletedCount);
    }
}