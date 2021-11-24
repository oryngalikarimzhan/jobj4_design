package ru.job4j.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgumentsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args)
                .peek(s -> {
                    if (s.startsWith("=")
                            || s.endsWith("=")
                            || !s.startsWith("-")
                            || s.startsWith("-=")
                            || s.startsWith("==")) {
                        throw new IllegalArgumentException("Does not match the pattern -key=value");
                    }
                })
                .filter(s -> s.contains("="))
                .map(s -> s.split("="))
                .forEach(str -> values.put(str[0].substring(1), str[1]));
    }

    public static ArgumentsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Do not have an arguments");
        }
        ArgumentsName names = new ArgumentsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgumentsName jvm = ArgumentsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgumentsName zip = ArgumentsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}