package service;

import enumerate.event.EventConstant;
import enumerate.menu.MenuGroup;
import model.Reservation;
import util.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EventService {
    private final Reservation reservation;
    private final LocalDate CHRISTMAS_DAY_SALE_STARTDATE = LocalDate.of(2024, 12, 1);
    private final LocalDate CHRISTMAS_DAY_SALE_FINISHDATE = LocalDate.of(2024, 12, 25);

    public EventService(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isAvailableEvent() {
        return reservation.totalOrderPrice() > EventConstant.EVENT_MIN_PRICE.getValue();
    }

    public int getChristmasDayEventPrice() {
        if (reservation.isRange(CHRISTMAS_DAY_SALE_STARTDATE, CHRISTMAS_DAY_SALE_FINISHDATE)) {
            return calculateChristmasDayEventPrice();
        }
        return 0;
    }

    private int calculateChristmasDayEventPrice() {
        int CHRISTMAS_DAY_SALE_STARTPRICE = 1000;
        int CHRISTMAS_DAY_SALE_UNIT = 100;
        int untilChristmasDate = reservation.calcaulateUntilChristmasDate(CHRISTMAS_DAY_SALE_STARTDATE);

        return CHRISTMAS_DAY_SALE_STARTPRICE + untilChristmasDate * CHRISTMAS_DAY_SALE_UNIT;
    }

}
