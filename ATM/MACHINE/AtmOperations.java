package ATM.MACHINE;

public interface AtmOperations {
    public void withDrawAmount(double withdrawAmount);

    public void depositAmount(double depositAmount);

    public void checkAvailableAmount();

    public void viewMiniStatement();
}
