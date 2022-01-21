package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.function.Predicate;

public class XMLReport implements Report {

    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        for (Employee employee : store.findBy(filter)) {
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employee, writer);
                text.append(writer.getBuffer())
                        .append(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return text.toString();
    }
}
