package ATM.MACHINE;

import ATM.MACHINE.Exceptions.InvalidAmountException;
import ATM.MACHINE.Exceptions.InvalidAtmNumberException;
import ATM.MACHINE.Exceptions.InvalidPinException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static final String atmNumber = "9398049275";
    static final int pin = 1702;

    static AtmOperationImplementation atm = new AtmOperationImplementation();
    static Scanner s = new Scanner(System.in);

    private static String getAtmNumber() {
        System.out.println("Enter ur atm number: ");
        return s.nextLine();
    }

    private static int getPin() {
        System.out.println("Enter ur atm pin: ");
        return s.nextInt();
    }

    public static void main(String[] args) {
        if (validateUser())
            performOperations();
    }

    private static boolean validateUser() {
        String atmNum = getAtmNumber();
        int atmPin = getPin();
        if (atmNum.length() != 10) {
            throw new InvalidAtmNumberException("Atm Number is incorrect, must be 10 digits !");
        }
        if (String.valueOf(atmPin).length() != 4) {
            throw new InvalidPinException("Length must be 4 and must be positive");
        }
        if (!atmNumber.equals(atmNum)) {
            throw new InvalidAtmNumberException("Atm Number Not Matching With Our Records ...");
        }
        if (pin != atmPin) {
            throw new InvalidPinException("Atm Pin Not Matching With Our Records...");
        }
        return true;

    }

    private static void showOptions() {
        System.out.println("ATM MACHINE\n" +
                "1. Check Available Balance\n" +
                "2. Deposit Amount\n" +
                "3. Withdraw Amount\n" +
                "4. Get Mini Statement\n" +
                "5. Exit");
        System.out.println("select an option");
    }

    private static int getChoice() {
        return s.nextInt();
    }

    private static void performOperations() {
        while (true) {
            showOptions();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    atm.checkAvailableAmount();
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = s.nextDouble();
                    if (depositAmount <= 0)
                        throw new InvalidAmountException("Amount must be greater than zero....");
                    atm.depositAmount(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter the amount u need to withdraw: ");
                    double withdrawAmount = s.nextDouble();
                    if (withdrawAmount <= 0)
                        throw new InvalidAmountException("Amount must be greater than zero....");
                    atm.withDrawAmount(withdrawAmount);
                    break;
                case 4:
                    System.out.println("MINI STATEMENT");
                    atm.viewMiniStatement();
                    break;
                case 5:
                    System.out.println("Thank You !.........");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection");
                    showOptions();
            }
        }
    }
}
