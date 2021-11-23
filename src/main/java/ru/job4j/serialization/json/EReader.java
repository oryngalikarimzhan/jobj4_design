package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "ereader")
@XmlAccessorType(XmlAccessType.FIELD)
public class EReader {
    @XmlAttribute
    private boolean waterProof;
    @XmlAttribute
    private boolean wirelessCharging;
    @XmlAttribute
    private int screenSize;

    private Brand brand;

    @XmlElementWrapper(name = "readingformats")
    @XmlElement(name = "readingformat")
    private String[] readingFormats;

    public EReader() {
    }

    public EReader(boolean waterProof, boolean wirelessCharging, int screenSize, Brand brand, String[] readingFormats) {
        this.waterProof = waterProof;
        this.wirelessCharging = wirelessCharging;
        this.screenSize = screenSize;
        this.brand = brand;
        this.readingFormats = readingFormats;
    }

    @Override
    public String toString() {
        return "EReader{"
                + "waterProof=" + waterProof
                + ", wirelessCharging=" + wirelessCharging
                + ", screenSize=" + screenSize
                + ", brand=" + brand
                + ", readingFormats=" + Arrays.toString(readingFormats)
                + '}';
    }
}
