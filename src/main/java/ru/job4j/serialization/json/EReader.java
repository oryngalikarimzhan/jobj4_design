package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isWaterProof() {
        return waterProof;
    }

    public boolean isWirelessCharging() {
        return wirelessCharging;
    }

    public int getScreenSize() {
        return screenSize;
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

    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonBrand = new JSONObject(
                "{\"brandName\":\"Onyx Boox\", "
                        + "\"model\":\"Nova 3 Color\", "
                        + "\"founded\":\"2006\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("pdf");
        list.add("word");
        list.add("xml");
        JSONArray jsonReadingFormats = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final EReader eReader = new EReader(false, false, 8,
                new Brand("Pocketbook", "Inkpad 3 Color", "2006"),
                new String[] {"mp3", "word", "xml"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("waterProof", eReader.isWaterProof());
        jsonObject.put("wirelessCharging", eReader.isWirelessCharging());
        jsonObject.put("screenSize", eReader.getScreenSize());
        jsonObject.put("brand", jsonBrand);
        jsonObject.put("readingFormats", jsonReadingFormats);


        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(eReader).toString());
    }
}
