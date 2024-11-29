package view;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import message.InputMessage;
import model.Reservation;
import repository.ReservationRepository;
import validator.InputValidator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Input {
    private final InputValidator inputValidator;
    private ReservationRepository reservationRepository;

    public Input(ReservationRepository reservationRepository) {
        inputValidator = new InputValidator();
        this.reservationRepository = reservationRepository;
    }

    public void processReservation() {
        System.out.println(InputMessage.GREETINGS.get());

        requestVisitDate();
        requestOrder();
    }

    private void requestVisitDate() {
        System.out.println(InputMessage.REQUEST_VISIT_DATE.get());
        String input = Console.readLine();

        handleVisitDateInput(input);

        reservationRepository.saveReservationVisitDate(Integer.parseInt(input));
    }

    private void handleVisitDateInput(String input) {
        while (true) {
            try {
                inputValidator.validatorVisitDate(input);
                break;
            } catch (CustomException e) {
                input = Console.readLine();
            }
        }
    }


    private void requestOrder() {
        System.out.println(InputMessage.REQUEST_ORDER.get());
        String input = Console.readLine();

        Map<String, Integer> orderDetails = handleOrderInput(input);

        reservationRepository.saveReservationOrders(orderDetails);
    }

    private Map<String, Integer> handleOrderInput(String input) {
        Map<String, Integer> orderDetails;

        while (true) {
            String[] splitInput = input.split(",");
            try {
                inputValidator.validatorOrder(splitInput);
                orderDetails = parseOrder(splitInput);
                inputValidator.validatorOrderDetails(orderDetails);
                break;
            } catch (CustomException e) {
                input = Console.readLine();
            }
        }
        return orderDetails;
    }

    private Map<String, Integer> parseOrder(String[] splitInput) {

        return Arrays.stream(splitInput)
                .map(order -> order.split("-"))
                .collect(Collectors.toMap(parts -> parts[0], parts -> Integer.parseInt(parts[1])));
    }
}
