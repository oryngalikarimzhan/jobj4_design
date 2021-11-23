package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Info {
    public static void main(String[] args) {
        final EReader reader = new EReader(true, false, 8,
                new Brand("Onyx Boox", "Nova 3 Color", "2006"),
                new String[] {"pdf", "word", "xml"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(reader));

        final String readerJson =
                "{"
                        + "\"waterProof\":false,"
                        + "\"wirelessCharging\":false,"
                        + "\"screenSize\":8,"
                        + "\"brand\":"
                        + "{"
                        + "\"brandName\":\"PocketBook\","
                        + "\"model\":\"Inkpad 3 Color\","
                        + "\"founded\":\"2007\""
                        + "},"
                        + "\"readingFormats\":"
                        + "[\"pdf\",\"word\",\"xml\"]"
                        + "}";
        final EReader readerMod = gson.fromJson(readerJson, EReader.class);
        System.out.println(readerMod);
    }
}
