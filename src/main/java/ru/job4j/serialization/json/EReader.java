package ru.job4j.serialization.json;

import java.util.Arrays;

public class EReader {
    private final boolean waterProof;
    private final boolean wirelessCharging;
    private final int screenSize;
    private final Brand brand;
    private final String[] readingFormats;

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
