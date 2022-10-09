package ATM.MACHINE.Exceptions;

public class NoTransactionException extends RuntimeException {
    public NoTransactionException(String message) {
        super(message);
    }
}
