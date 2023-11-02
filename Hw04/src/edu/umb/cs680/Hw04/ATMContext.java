package edu.umb.cs680.Hw04;

public class ATMContext {
    private ATMState state;
    private int balance;
    private int remainingAttempts;

    public ATMContext() {
        state = NoCardState.getInstance();
        balance = 1000;
        remainingAttempts = 3;
    }

    public ATMState getState() {
        return state;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void insertCard() {
        state.insertCard(this);
    }

    public void ejectCard() {
        state.ejectCard(this);
        resetAttempts();
    }

    private void resetAttempts() {
        this.remainingAttempts = 3;
    }

    public void enterPin(String pin) {
        state.enterPin(this, pin);
    }

    public void withdrawCash(int amount) {
        state.withdrawCash(this, amount);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public void setRemainingAttempts(int remainingAttempts) {
        this.remainingAttempts = remainingAttempts;
    }

    public void displayState() {
        System.out.println("ATM is in " + state + " state.");
    }

    public static void main(String[] args) {
        ATMContext atm = new ATMContext();

        atm.displayState();
        atm.insertCard();
        atm.displayState();

        atm.enterPin("1234");
        atm.displayState();

        atm.withdrawCash(200);
        atm.displayState();

        atm.ejectCard();
        atm.displayState();
    }
}
