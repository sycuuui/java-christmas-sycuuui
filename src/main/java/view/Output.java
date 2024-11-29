package view;

import enumerate.event.EventDate;
import handler.OutputHandler;
import model.Reservation;
import service.EventService;

import static enumerate.event.EventDate.CHRISTMAS_DATE;

public class Output {
    private final OutputHandler outputHandler;
    private final Reservation reservation;
    private final EventService eventService;

    public Output(OutputHandler outputHandler, Reservation reservation, EventService eventService) {
        this.outputHandler = outputHandler;
        this.reservation = reservation;
        this.eventService = eventService;
    }

    public void printResult() {
        printHeader();
    }

    private void printHeader() {
        System.out.println(outputHandler.getHeaderMessage(reservation.getVisitMonth(), reservation.getVisitDay()));
    }
}
