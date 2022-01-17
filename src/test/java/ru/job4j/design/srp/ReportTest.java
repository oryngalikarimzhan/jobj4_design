package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

public class ReportTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateHtmlForDev() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report devReport = new ReportForDev(store);
        String ln = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(ln)
                .append("<html lang=\"EN\">").append(ln)
                .append("<head>").append(ln)
                .append("<meta charset=\"UTF-8\">").append(ln)
                .append("<title>Report</title>").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln)
                .append("<p>Name; Hired; Fired; Salary;</p>").append(ln)
                .append("<p>")
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary()).append(";")
                .append("</p>").append(ln)
                .append("</body>").append(ln).append("</html>");
        assertThat(devReport.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 90);
        Employee worker3 = new Employee("Oryngali", now, now, 120);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report hrDept = new ReportForHRDept(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append("; ")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hrDept.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateForAcc() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report accDept = new ReportForAccDept(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary()).append(" руб.").append(";")
                .append(System.lineSeparator());
        assertThat(accDept.generate(em -> true), is(expect.toString()));
    }
}