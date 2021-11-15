package ru.job4j.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int changedCount = 0;
        int deletedCount = 0;
        int sameCount = 0;
        Iterator<User> prevIter = previous.iterator();
        Iterator<User> currIter = current.iterator();
        while (prevIter.hasNext()) {
            User pre = prevIter.next();
            if (current.contains(pre)) {
                sameCount++;
            } else {
                int checker = changedCount;
                while (currIter.hasNext() && changedCount == checker) {
                    User cur = currIter.next();
                    if (pre.getId() == cur.getId()) {
                        changedCount++;
                    }
                }
                if (checker == changedCount) {
                    deletedCount++;
                }
            }
        }
        int addedCount = current.size() - sameCount - changedCount;
        return new Info(addedCount, changedCount, deletedCount);
    }
}