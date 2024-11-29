package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private LocalDate visitDate;
    private final List<Order> orders;

    public Reservation() {
        this.visitDate = null;
        this.orders = new ArrayList<>();
    }

    public void setVisitDate(int visitDay) {
        this.visitDate = LocalDate.of(2024,12,visitDay);
    }

    public void addOrder(Order order) {
        orders.add(order);
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
        return (int) ChronoUnit.DAYS.between(startDate,visitDate);
    }
}
