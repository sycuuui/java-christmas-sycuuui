package controller;

import view.Input;

public class ReservationController {
    private final Input input;

    public ReservationController(Input input) {
        this.input = input;
    }

    public void run() {
        input.processReservation();
    }

}
