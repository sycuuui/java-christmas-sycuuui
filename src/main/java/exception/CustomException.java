package exception;

import message.ErrorMessage;

public class CustomException extends IllegalArgumentException {
    public CustomException(ErrorMessage message) {
        super("[ERROR] " + message.get());
    }
}
