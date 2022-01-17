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
        String ln = System.lineSeparator();
        text.append("<!DOCTYPE html>").append(ln)
                .append("<html lang=\"EN\">").append(ln)
                .append("<head>").append(ln)
                .append("<meta charset=\"UTF-8\">").append(ln)
                .append("<title>Report</title>").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln)
                .append("<p>Name; Hired; Fired; Salary;</p>").append(ln);

        for (Employee employee : store.findBy(filter)) {
            text.append("<p>")
                    .append(employee.getName()).append("; ")
                    .append(employee.getHired()).append("; ")
                    .append(employee.getFired()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append("</p>")
                    .append(ln);
        }
        text.append("</body>").append(ln).append("</html>");
        return text.toString();
    }
}




