package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "brand")
public class Brand {
    @XmlAttribute
    private String brandName;
    @XmlAttribute
    private String model;
    @XmlAttribute
    private String founded;

    public Brand() {
    }

    public Brand(String brandName, String model, String founded) {
        this.brandName = brandName;
        this.model = model;
        this.founded = founded;
    }

    @Override
    public String toString() {
        return "Brand{"
                + "brandName='" + brandName + '\''
                + ", model='" + model + '\''
                + ", founded=" + founded
                + '}';
    }
}
