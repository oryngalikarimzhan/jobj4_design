package ru.job4j.design.dip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    int age;

    public String getName() {
        return name;
    }
}

class SearchByName {
    private ListStorage listStorage;

    public SearchByName(ListStorage listStorage) {
        this.listStorage = listStorage;
    }

    public Person search(String name) {
        Person wanted = null;
        for (Person person : listStorage.getAll()) {
            if (person.getName().equals(name)) {
                wanted = person;
            }
        }
        return wanted;
    }
}

class MapStorage {
    private Map<String, Person> personList;

    public MapStorage() {
        personList = new HashMap<>();
    }

    public void add(Person person) {
        personList.put(person.getName(), person);
    }
}

class ListStorage {
    private List<Person> personList;

    public ListStorage() {
        personList = new ArrayList<>();
    }

    public void add(Person person) {
        personList.add(person);
    }

    public List<Person> getAll() {
        return new ArrayList<>(personList);
    }
}

