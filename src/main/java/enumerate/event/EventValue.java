package enumerate.event;

import enumerate.menu.Menu;

public enum EventValue {
    CHRISTMAS_DAY_INIT_VALUE(1000),
    CHRISTMAS_DAY_UNIT(100),
    WEEK_DISCOUNT_VALUE(2023),
    SPECIAL_DISCOUNT_VALUE(1000),
    GIFT_CONDITION_PRICE(120000),
    GIFT_DISCOUNT_VALUE(Menu.CHAMPAGNE.getPrice()),
    EVENT_MIN_ORDER(1),
    EVENT_MAX_ORDER(20),
    EVENT_MIN_PRICE(10000),
    NO_EVENT_VALUE(0);

    private final int value;

    EventValue(int value) {
        this.value = value;
    }

    public int get() {
        return this.value;
    }
}