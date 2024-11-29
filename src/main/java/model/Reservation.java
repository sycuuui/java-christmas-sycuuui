package model;

import enumerate.event.EventConstant;
import enumerate.event.EventDate;
import enumerate.event.WeekEvent;
import util.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static enumerate.event.EventConstant.NO_EVENT_VALUE;
import static enumerate.event.EventConstant.SPECIAL_DISCOUNT_VALUE;
import static enumerate.event.EventDate.CHRISTMAS_DAY;

public class Reservation {
    private LocalDate visitDate;
    private final List<Order> orders;

    public Reservation() {
        this.visitDate = null;
        this.orders = new ArrayList<>();
    }

    public void setVisitDate(int visitDay) {
        this.visitDate = LocalDate.of(2024, 12, visitDay);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    private DayOfWeek getDayOfWeek() {
        return DateUtil.DateToDayConverter(visitDate);
    }

    private int getWeekEventPrice(Order order) {
        return WeekEvent.getWeekEventPrice(getDayOfWeek(), order.getMenuGroup());
    }

    public int getTotalWeekEventPrice() {
        return orders.stream()
                .mapToInt(this::getWeekEventPrice)
                .sum();
    }

    public int getSpecialEventPrice() {
        if (getDayOfWeek() == DayOfWeek.SUNDAY || CHRISTMAS_DAY.isChristmasDay(visitDate)) {
            return SPECIAL_DISCOUNT_VALUE.get();
        }
        return NO_EVENT_VALUE.get();
    }

    public int totalOrderPrice() {
        return orders.stream()
                .mapToInt(Order::orderPrice)
                .sum();
    }

    public boolean isRange(LocalDate startDate, LocalDate endDate) {
        return (visitDate.isEqual(startDate) || visitDate.isAfter(startDate)) &&
                (visitDate.isEqual(endDate) || visitDate.isAfter(endDate));
    }

    public int calcaulateUntilChristmasDate(LocalDate startDate) {
        return (int) ChronoUnit.DAYS.between(startDate, visitDate);
    }
}
