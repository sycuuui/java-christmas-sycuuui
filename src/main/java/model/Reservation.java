package model;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int visitDate;
    private final List<Order> orders;

    public Reservation() {
        this.visitDate = 0;
        this.orders = new ArrayList<>();
    }

    public void setVisitDate(int visitDate) {
        this.visitDate = visitDate;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
