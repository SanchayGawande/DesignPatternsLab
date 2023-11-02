package edu.umb.cs680.Hw04;

public class NoCardState implements ATMState {
    private static NoCardState instance = null;

    private NoCardState() {}

    public static NoCardState getInstance() {
        if (instance == null) {
            instance = new NoCardState();
        }
        return instance;
    }

    @Override
    public void insertCard(ATMContext context) {
        System.out.println("Card inserted.");
        context.setState(CardInsertedState.getInstance());
    }

    @Override
    public void ejectCard(ATMContext context) {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(ATMContext context, String pin) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void withdrawCash(ATMContext context, int amount) {
        System.out.println("Please insert card first.");
    }
}
