package repository;

import model.Order;
import model.Reservation;
import view.Input;

import java.util.Map;

public class ReservationRepository {
    private Reservation reservation;

    public ReservationRepository(Reservation reservation) {
        this.reservation = reservation;
    }

    public void saveReservationVisitDate(int visitDate) {
        reservation.setVisitDate(visitDate);
    }

    public void saveReservationOrders(Map<String, Integer> orderDetails) {
        orderDetails.entrySet().stream()
                .map(orderDetail -> new Order(orderDetail.getKey(), orderDetail.getValue()))
                .forEach(order -> reservation.addOrder(order));
    }
}
