package model;

import enumerate.event.WeekEvent;
import message.OutputMessage;
import util.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static enumerate.event.EventDate.CHRISTMAS_DATE;
import static enumerate.event.EventValue.NO_EVENT_VALUE;
import static enumerate.event.EventValue.SPECIAL_DISCOUNT_VALUE;
import static message.OutputMessage.*;

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

    public OutputMessage getWeekEventKind() {
        Optional<WeekEvent> weekEvent = WeekEvent.getWeekEventKind(getDayOfWeek());
        if(weekEvent.equals(WeekEvent.WEEKDAY)) {
            return EVENT_NAME_WEEKDAY;
        }
        if(weekEvent.equals(WeekEvent.WEEKEND)) {
            return EVENT_NAME_WEEKEND;
        }
        return NOTICE_NO_EVENT;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getVisitMonth() {
        return visitDate.getMonthValue();
    }

    public int getVisitDay() {
        return visitDate.getDayOfMonth();
    }

    public int getTotalWeekEventPrice() {
        return orders.stream()
                .mapToInt(this::getWeekEventPrice)
                .sum();
    }

    public int getSpecialEventPrice() {
        if (getDayOfWeek() == DayOfWeek.SUNDAY || CHRISTMAS_DATE.isChristmasDay(visitDate)) {
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
