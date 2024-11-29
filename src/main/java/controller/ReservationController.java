package controller;

import handler.OutputHandler;
import model.Reservation;
import service.EventService;
import view.Input;
import view.Output;

public class ReservationController {
    private final Input input;
    private final Reservation reservation;


    public ReservationController(Input input,Reservation reservation) {
        this.input = input;
        this.reservation = reservation;
    }

    public void run() {
        input.processReservation();

        processResult();
    }

    public void processResult() {
        EventService eventService = new EventService(reservation);
        OutputHandler outputHandler = new OutputHandler();
        Output output = new Output(outputHandler,reservation,eventService);

        output.printResult();
    }
}
