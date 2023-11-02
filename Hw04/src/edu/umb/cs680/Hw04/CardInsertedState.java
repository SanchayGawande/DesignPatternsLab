package edu.umb.cs680.Hw04;

public class CardInsertedState implements ATMState {
    private static CardInsertedState instance = null;

    private CardInsertedState() {}

    public static CardInsertedState getInstance() {
        if (instance == null) {
            instance = new CardInsertedState();
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
        if (pin.equals("1234")) {
            System.out.println("Correct PIN entered.");
            context.setState(PinEnteredState.getInstance());
        } else {
            System.out.println("Incorrect PIN.");
            context.setRemainingAttempts(context.getRemainingAttempts() - 1);
            if (context.getRemainingAttempts() <= 0) {
                System.out.println("Card retained due to multiple incorrect PIN attempts.");
                context.setState(NoCardState.getInstance());
            }
        }
    }

    @Override
    public void withdrawCash(ATMContext context, int amount) {
        System.out.println("Please enter PIN before withdrawing cash.");
    }
}
