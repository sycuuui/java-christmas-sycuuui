package christmas;

import controller.ReservationController;
import handler.OutputHandler;
import model.Reservation;
import repository.ReservationRepository;
import service.EventService;
import view.Input;

public class Application {
    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        ReservationRepository reservationRepository = new ReservationRepository(reservation);
        Input input = new Input(reservationRepository);

        ReservationController reservationController = new ReservationController(input,reservation);

        reservationController.run();
    }
}
