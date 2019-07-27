package sdaspringcar.cardemo.exception;

public class IncorrectPriceParseException extends Throwable {

    private final String errorMessage;

    public IncorrectPriceParseException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
