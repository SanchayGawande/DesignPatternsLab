package edu.umb.cs680.Hw04;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATMContextTest {
    private ATMContext atm;

    @BeforeEach
    public void setUp() {
        atm = new ATMContext();
    }

    @Test
    public void testInitialState() {
        assertTrue(atm.getState() instanceof NoCardState);
    }

    @Test
    public void testInsertCard() {
        atm.insertCard();
        assertTrue(atm.getState() instanceof CardInsertedState);
    }

    @Test
    public void testEjectCard() {
        atm.insertCard();
        atm.ejectCard();
        assertTrue(atm.getState() instanceof NoCardState);
    }

    @Test
    public void testEnterCorrectPin() {
        atm.insertCard();
        atm.enterPin("1234");
        assertTrue(atm.getState() instanceof PinEnteredState);
    }

    @Test
    public void testEnterIncorrectPin() {
        atm.insertCard();
        atm.enterPin("5335");
        assertTrue(atm.getState() instanceof CardInsertedState);
        atm.enterPin("7252");
        assertTrue(atm.getState() instanceof CardInsertedState);
        atm.enterPin("7436");
        assertTrue(atm.getState() instanceof NoCardState);
    }

    @Test
    public void testWithdrawCashWithCorrectPin() {
        atm.insertCard();
        atm.enterPin("1234");
        atm.withdrawCash(500);
        assertTrue(atm.getState() instanceof NoCardState);
        assertEquals(500, atm.getBalance());
    }

    @Test
    public void testWithdrawCashWithInsufficientBalance() {
        atm.insertCard();
        atm.enterPin("1234");
        atm.withdrawCash(1500);
        assertTrue(atm.getState() instanceof PinEnteredState);
        assertEquals(1000, atm.getBalance());
    }

    @Test
    public void testWithdrawNegativeAmount() {
        atm.insertCard();
        atm.enterPin("1234");
        int initialBalance = atm.getBalance();
        atm.withdrawCash(-500);

        assertTrue(atm.getState() instanceof PinEnteredState, "ATM should remain in PinEnteredState");
        assertEquals(initialBalance, atm.getBalance(), "Balance should remain unchanged after invalid withdrawal");
    }


    @Test
    public void testWithdrawCashWithoutEnteringPin() {
        atm.insertCard();
        atm.withdrawCash(200);
        assertTrue(atm.getState() instanceof CardInsertedState);
        assertEquals(1000, atm.getBalance());
    }

    @Test
    public void testMultipleCardInsertions() {
        atm.insertCard();
        atm.insertCard();
        assertTrue(atm.getState() instanceof CardInsertedState);
    }

    @Test
    public void testEjectingCardWhileNoCardIsInserted() {
        atm.ejectCard();
        assertTrue(atm.getState() instanceof NoCardState);
    }
}
