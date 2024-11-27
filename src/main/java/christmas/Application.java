package christmas;

import controller.ReservationController;
import model.Reservation;
import repository.ReservationRepository;
import view.Input;

public class Application {
    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        ReservationRepository reservationRepository = new ReservationRepository(reservation);
        Input input = new Input(reservationRepository);
        ReservationController reservationController = new ReservationController(input);

        reservationController.run();
    }
}
