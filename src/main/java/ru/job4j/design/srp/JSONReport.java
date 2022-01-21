package ru.job4j.design.srp;

import com.google.gson.*;
import java.util.function.Predicate;

public class JSONReport implements Report {

    private Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var lib = new GsonBuilder().setPrettyPrinting().create();
        return lib.toJson(store.findBy(filter));
    }
}
