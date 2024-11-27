package christmas;

import controller.ReservationController;
import model.Reservation;
import view.Input;

public class Application {
    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        Input input = new Input(reservation);
        ReservationController reservationController = new ReservationController(input);

        reservationController.run();
    }
}
