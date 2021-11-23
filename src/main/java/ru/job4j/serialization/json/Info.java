package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Info {
    public static void main(String[] args) throws Exception {
        final EReader ereader = new EReader(true, false, 8,
                new Brand("Onyx Boox", "Nova 3 Color", "2006"),
                new String[] {"pdf", "word", "xml"});
        JAXBContext context = JAXBContext.newInstance(EReader.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(ereader, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            EReader result = (EReader) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
