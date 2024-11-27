package view;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import message.InputMessage;
import model.Reservation;
import validator.InputValidator;

public class Input {
    private final InputValidator inputValidator;
    private Reservation reservation;

    public Input(Reservation reservation) {
        inputValidator = new InputValidator();
        this.reservation = reservation;
    }

    public void processReservation() {
        System.out.println(InputMessage.GREETINGS.get());
        requestVisitDate();
    }

    private void requestVisitDate() {
        System.out.println(InputMessage.REQUEST_VISIT_DATE.get());
        String input = Console.readLine();

        while (true) {
            try {
                inputValidator.visitDate(input);
                reservation.setVisitDate(Integer.parseInt(input));
                break;
            } catch (CustomException e) {
                input = Console.readLine();
            }
        }
    }
}
