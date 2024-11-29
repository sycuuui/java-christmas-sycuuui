package enumerate;

public enum EventConstant {
    D_DAY_DISCOUNT_INIT_VALUE(1000),
    D_DAY_INCREASE_VALUE(100),
    D_DAY_EVENT_LAST_DAY(25),
    WEEK_DISCOUNT_VALUE(2023),
    SPECIAL_DISCOUNT_VALUE(1000),
    SPECIAL_EVENT_SUNDAY_OTHER_DAY(25),
    GIFT_CONDITION_PRICE(120000),
    GIFT_DISCOUNT_VALUE(CHAMPAGNE.price()),
    BADGE_LEVEL_1_VALUE(5000),
    BADGE_LEVEL_2_VALUE(10000),
    BADGE_LEVEL_3_VALUE(20000),
    EVENT_YEAR(2023),
    EVENT_MONTH(12),
    EVENT_MIN_DATE(1),
    EVENT_MAX_DATE(31),
    EVENT_MIN_ORDER(1),
    EVENT_MAX_ORDER(20),
    EVENT_MIN_PRICE(10000);

    private final int value;

    EventConstant(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}