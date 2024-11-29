package service;

import enumerate.event.EventValue;
import model.Reservation;

import static enumerate.event.EventValue.*;
import static enumerate.event.EventDate.CHRISTMAS_DAY_SALE_FINISHDATE;
import static enumerate.event.EventDate.CHRISTMAS_DAY_SALE_STARTDATE;

public class EventService {
    private final Reservation reservation;

    public EventService(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isConditionEvent() {
        return reservation.totalOrderPrice() > EventValue.EVENT_MIN_PRICE.get();
    }

    public int getChristmasDayEventPrice() {
        if (isConditionEvent() && reservation.isRange(CHRISTMAS_DAY_SALE_STARTDATE.get(), CHRISTMAS_DAY_SALE_FINISHDATE.get())) {
            return calculateChristmasDayEventPrice();
        }
        return NO_EVENT_VALUE.get();
    }

    private int calculateChristmasDayEventPrice() {
        int untilChristmasDate = reservation.calcaulateUntilChristmasDate(CHRISTMAS_DAY_SALE_STARTDATE.get());

        return CHRISTMAS_DAY_INIT_VALUE.get() + (untilChristmasDate * CHRISTMAS_DAY_UNIT.get());
    }

    public boolean isConditionGift() {
        return isConditionEvent() && (reservation.totalOrderPrice() > GIFT_CONDITION_PRICE.get());
    }

    public int getConditionGiftPrice() {
        if(isConditionEvent() && isConditionGift()) {
            return GIFT_DISCOUNT_VALUE.get();
        }
        return NO_EVENT_VALUE.get();
    }

    public int totalEventPrice() {
        return getChristmasDayEventPrice()
                + getConditionGiftPrice()
                + reservation.getSpecialEventPrice()
                + reservation.getTotalWeekEventPrice();
    }

    public int totalPrice() {
        return reservation.totalOrderPrice() - totalEventPrice() + getConditionGiftPrice();
    }
}
