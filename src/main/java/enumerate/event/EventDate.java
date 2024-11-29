package enumerate.event;

import java.time.LocalDate;

public enum EventDate {
    CHRISTMAS_DAY_SALE_STARTDATE(LocalDate.of(2023, 12, 1)),
    CHRISTMAS_DAY_SALE_FINISHDATE(LocalDate.of(2023, 12, 25)),
    CHRISTMAS_DATE(LocalDate.of(2023, 12, 25)),
    EVENT_DATE(LocalDate.of(2023,12,1));

    private final LocalDate date;

    EventDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate get() {
        return date;
    }

    public boolean isChristmasDay(LocalDate localDate) {
        return CHRISTMAS_DATE.get() == localDate;
    }
}
