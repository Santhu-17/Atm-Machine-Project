package ATM.MACHINE.Exceptions;

public class InvalidAtmNumberException extends RuntimeException {
    public InvalidAtmNumberException(String message) {
        super(message);
    }
}
