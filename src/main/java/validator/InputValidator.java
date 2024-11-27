package validator;

import exception.CustomException;
import message.ErrorMessage;

public class InputValidator {
    public void visitDate(String input) {
        if(input.isEmpty())  throw new CustomException(ErrorMessage.INVALID_DATE);
        if(!isNumber(input))  throw new CustomException(ErrorMessage.INVALID_DATE);
        if(!isInDateRange(input))  throw new CustomException(ErrorMessage.INVALID_DATE);
    }

    private boolean isNumber(String input) {
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isInDateRange(String input) {
        int visitDate = Integer.parseInt(input);

        return visitDate >= 1 && visitDate <= 31;
    }
}
