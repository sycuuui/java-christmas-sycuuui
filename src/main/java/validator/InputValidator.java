package validator;

import enumerate.Menu;
import exception.CustomException;
import message.ErrorMessage;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public void validatorVisitDate(String input) {
        if (input.isEmpty()) throw new CustomException(ErrorMessage.INVALID_DATE);
        isNumber(input);
        checkInDateRange(input);
    }

    public void validatorOrder(String[] splitInput) {
        for (String order : splitInput) {
            checkOrderRegex(order);
        }
    }

    public void validatorOrderDetails(Map<String, Integer> orderDetails) {
        int totalQuantity = 0;

        checkDuplicationMenu(orderDetails);
        for (Map.Entry<String, Integer> entry : orderDetails.entrySet()) {
            totalQuantity += entry.getValue();
            checkInMenu(entry.getKey());
            checkInQuantityRange(entry.getValue());
        }
        checkInTotalQuantityRange(totalQuantity);
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorMessage.INVALID_DATE);
        }
    }

    private void checkInDateRange(String input) {
        int visitDate = Integer.parseInt(input);

        if (!(visitDate >= 1 && visitDate <= 31)) {
            throw new CustomException(ErrorMessage.INVALID_DATE);
        }
    }

    private void checkOrderRegex(String input) {
        String regex = "^[가-힣]+-(\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new CustomException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void checkDuplicationMenu(Map<String, Integer> orderDetails) {
        Set<String> keySet = new HashSet<>(orderDetails.keySet());

        if (keySet.size() != orderDetails.keySet().size()) {
            throw new CustomException(ErrorMessage.INVALID_DATE);
        }
    }

    private void checkInMenu(String key) {
        Menu menu = Menu.findMenuByName(key);

        if (menu == null) {
            throw new CustomException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void checkInQuantityRange(Integer value) {
        if (value < 1) {
            throw new CustomException(ErrorMessage.INVALID_ORDER);
        }
    }

    private void checkInTotalQuantityRange(int totalQuantity) {
        if (totalQuantity > 20) {
            throw new CustomException(ErrorMessage.INVALID_ORDER);
        }
    }
}
