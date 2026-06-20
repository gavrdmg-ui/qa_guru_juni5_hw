package data;

public enum ClothesSubCategories {
    JACKETS("Куртки"),
    COAT("Пальто"),
    CLOAKS("Плащи"),
    FUR_COATS("Шубы"),
    PANTS("Брюки"),
    CULOTTES("Кюлоты"),
    LONGSLEEVES("Лонгсливы"),
    TOPS("Топы"),
    T_SHIRTS("Футболки"),
    HOODIES_SWEATSHIRTS("Худи и толстовки"),
    BLOUSES_SHIRTS("Блузки и рубашки"),
    TURTLENECKS("Водолазки"),
    CARDIGANS("Кардиганы"),
    BAGS("Сумки"),
    BELTS("Ремни"),
    SCARVES_SHAWLS("Шарфы, платки"),
    BIJOUTERIE("Бижутерия");

    public final String description;

    ClothesSubCategories(String description) {
        this.description = description;
    }
}
