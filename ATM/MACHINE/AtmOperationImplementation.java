package ATM.MACHINE;

import ATM.MACHINE.Exceptions.InSufficientBalanceException;
import ATM.MACHINE.Exceptions.NoTransactionException;
import java.util.HashMap;

public class AtmOperationImplementation implements AtmOperations {
    Atm atm = new Atm();
    HashMap<Double, String> miniStatement = new HashMap<>();
    @Override
    public void withDrawAmount(double withdrawAmount) {
        if (withdrawAmount > atm.getBalance()) {
            throw new InSufficientBalanceException("Insufficient balance please check ur balance");
        }
        miniStatement.put(withdrawAmount, " rs debited from ur account");
        atm.setBalance(atm.getBalance() - withdrawAmount);
        System.out.println(withdrawAmount + " rs debited from ur account");
    }

    @Override
    public void depositAmount(double depositAmount) {
        miniStatement.put(depositAmount, " rs credited to ur account");
        atm.setBalance(atm.getBalance() + depositAmount);
        System.out.println(depositAmount + " rs credited to ur account");
    }

    @Override
    public void checkAvailableAmount() {
        System.out.println("Your account balance is: " + atm.getBalance() + " rs");
    }

    @Override
    public void viewMiniStatement() {
        if (miniStatement.size() == 0)
            throw new NoTransactionException("No Transaction has been made");

        miniStatement.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
