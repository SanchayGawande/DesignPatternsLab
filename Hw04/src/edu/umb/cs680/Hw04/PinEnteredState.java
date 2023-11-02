package edu.umb.cs680.Hw04;

public class PinEnteredState implements ATMState {
    private static PinEnteredState instance = null;

    private PinEnteredState() {}

    public static PinEnteredState getInstance() {
        if (instance == null) {
            instance = new PinEnteredState();
        }
        return instance;
    }

    @Override
    public void insertCard(ATMContext context) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard(ATMContext context) {
        System.out.println("Card ejected.");
        context.setState(NoCardState.getInstance());
    }

    @Override
    public void enterPin(ATMContext context, String pin) {
        System.out.println("PIN already entered.");
    }

    @Override
    public void withdrawCash(ATMContext context, int amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (context.getBalance() >= amount) {
            context.setBalance(context.getBalance() - amount);
            System.out.println("Withdrawn: $" + amount + ". Remaining balance: $" + context.getBalance());
            context.setState(NoCardState.getInstance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

