package ru.job4j.serialization.json;

public class Brand {
    private final String brandName;
    private final String model;
    private final String founded;

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
