package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

    @Test
    public void whenGenerateXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 110);
        store.add(worker1);
        store.add(worker2);
        Report xmlReport = new XMLReport(store);
        StringBuilder expect = new StringBuilder();
        try {
            expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                    .append("<Employees>\n")
                    .append("    <Employee name=\"")
                    .append(worker1.getName())
                    .append("\" hired=\"")
                    .append(DatatypeFactory.newInstance()
                            .newXMLGregorianCalendar((GregorianCalendar) worker1.getHired()))
                    .append("\" fired=\"")
                    .append(DatatypeFactory.newInstance()
                            .newXMLGregorianCalendar((GregorianCalendar) worker1.getFired()))
                    .append("\" salary=\"").append(worker1.getSalary()).append("\"/>\n")
                    .append("    <Employee name=\"")
                    .append(worker2.getName())
                    .append("\" hired=\"")
                    .append(DatatypeFactory.newInstance()
                            .newXMLGregorianCalendar((GregorianCalendar) worker2.getHired()))
                    .append("\" fired=\"")
                    .append(DatatypeFactory.newInstance()
                            .newXMLGregorianCalendar((GregorianCalendar) worker2.getFired()))
                    .append("\" salary=\"").append(worker2.getSalary()).append("\"/>\n")
                    .append("</Employees>\n");
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        assertThat(xmlReport.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee(
                "Ivan",
                new GregorianCalendar(2021, 01, 01),
                new GregorianCalendar(2021, 01, 01),
                100
        );
        store.add(worker);
        Report jsonReport = new JSONReport(store);
        StringBuilder expect = new StringBuilder()
                .append("[\n")
                .append("  {\n")
                .append("    \"name\": \"Ivan\",\n")
                .append("    \"hired\": {\n")
                .append("      \"year\": 2021,\n")
                .append("      \"month\": 1,\n")
                .append("      \"dayOfMonth\": 1,\n")
                .append("      \"hourOfDay\": 0,\n")
                .append("      \"minute\": 0,\n")
                .append("      \"second\": 0\n")
                .append("    },\n")
                .append("    \"fired\": {\n")
                .append("      \"year\": 2021,\n")
                .append("      \"month\": 1,\n")
                .append("      \"dayOfMonth\": 1,\n")
                .append("      \"hourOfDay\": 0,\n")
                .append("      \"minute\": 0,\n")
                .append("      \"second\": 0\n")
                .append("    },\n")
                .append("    \"salary\": 100.0\n")
                .append("  }\n")
                .append("]");
        assertThat(jsonReport.generate(em -> true), is(expect.toString()));
    }
}