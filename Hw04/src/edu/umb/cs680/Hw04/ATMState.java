package edu.umb.cs680.Hw04;

interface ATMState {
    void insertCard(ATMContext context);
    void ejectCard(ATMContext context);
    void enterPin(ATMContext context, String pin);
    void withdrawCash(ATMContext context, int amount);
}