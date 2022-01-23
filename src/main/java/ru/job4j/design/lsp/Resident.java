package ru.job4j.design.lsp;

import java.util.*;

public class Resident {

    boolean conscientious;

    public Resident() {
        conscientious = true;
    }

    public boolean conscientiousness(Violations violations) {
        for (Integer heaviness : violations) {
            if (heaviness > 5) {
                conscientious = false;
                break;
            }
        }
        return conscientious;
    }
}

class Official extends Resident {

    public Official() {
        super();
    }

    @Override
    public boolean conscientiousness(Violations violations) {
        return conscientious;
    }
}

class Violations implements Iterable<Integer> {

    private Map<String, Integer> violations = new HashMap<>();

    public void add(String violation, Integer heaviness) {
        violations.put(violation, heaviness);
    }

    @Override
    public Iterator<Integer> iterator() {
        return violations.values().iterator();
    }

}

