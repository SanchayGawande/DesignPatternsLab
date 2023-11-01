package edu.umb.cs680.Hw04;

class NoCardState implements ATMState {
    private static final NoCardState instance = new NoCardState();
    NoCardState() {}

    public static NoCardState getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "No Card";
    }

    @Override
    public void insertCard(ATMContext context) {
        context.setState(new CardInsertedState());
        System.out.println("Card inserted.");
    }

    @Override
    public void ejectCard(ATMContext context) {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(ATMContext context, String pin) {
        System.out.println("Please insert a card first.");
    }

    @Override
    public void withdrawCash(ATMContext context, int amount) {
        System.out.println("Please insert a card and enter a PIN first.");
    }
}
