package ru.job4j.design.srp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

public class ReportForDev implements Report {

    private Store store;

    public ReportForDev(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append("; ")
                    .append(employee.getHired()).append("; ")
                    .append(employee.getFired()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        Path filePath = Path.of("./data/report.html");
        try {
            Files.writeString(filePath, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
