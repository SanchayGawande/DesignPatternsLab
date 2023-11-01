package edu.umb.cs680.Hw04;

class PinEnteredState implements ATMState {
    private static final PinEnteredState instance = new PinEnteredState();

    private PinEnteredState() {}

    public static PinEnteredState getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return "PIN Entered";
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
        System.out.println("PIN is already entered.");
    }

    @Override
    public void withdrawCash(ATMContext context, int amount) {
        if (amount <= context.getBalance()) {
            context.setBalance(context.getBalance() - amount);
            System.out.println("Cash withdrawn: $" + amount + ". New balance: $" + context.getBalance());
            context.setState(new NoCardState());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}