package edu.umb.cs680.Hw04;

class CardInsertedState implements ATMState {
    private static final CardInsertedState instance = new CardInsertedState();

    CardInsertedState() {}

    public static CardInsertedState getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "Card Inserted";
    }

    @Override
    public void insertCard(ATMContext context) {
        System.out.println("Card is already inserted.");
    }

    @Override
    public void ejectCard(ATMContext context) {
        context.setState(new NoCardState());
        System.out.println("Card ejected.");
    }

    @Override
    public void enterPin(ATMContext context, String pin) {
        if (pin.equals("1234")) {
            context.setState(PinEnteredState.getInstance());
            System.out.println("PIN entered successfully.");
        } else {
            context.setRemainingAttempts(context.getRemainingAttempts() - 1);
            if (context.getRemainingAttempts() == 0) {
                context.setState(NoCardState.getInstance());
                System.out.println("Card blocked due to too many incorrect PIN attempts.");
            } else {
                System.out.println("Incorrect PIN. " + context.getRemainingAttempts() + " attempts remaining.");
            }
        }
    }

    @Override
    public void withdrawCash(ATMContext context, int amount) {
        System.out.println("Please enter the correct PIN first.");
    }
}
