package data;

public enum ClothesCategory {

    OUTERWEAR("Верхняя одежда"),
    PANTS("Брюки"),
    TOPS("Топы"),
    KNITTED("Вязаный трикотаж"),
    ACCESSORIES("Аксессуары");


    public final String description;

    ClothesCategory(String description) {
        this.description = description;
    }
}
