package ATM.MACHINE.Exceptions;

public class InSufficientBalanceException extends RuntimeException {

    public InSufficientBalanceException(String message) {
        super(message);
    }

}
