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
        assertEquals("No Card", atm.getState().getName());
    }

    @Test
    public void testInsertCard() {
        atm.insertCard();
        assertEquals("Card Inserted", atm.getState().getName());
    }

    @Test
    public void testEjectCard() {
        atm.insertCard();
        atm.ejectCard();
        assertEquals("No Card", atm.getState().getName());
    }

    @Test
    public void testEnterCorrectPin() {
        atm.insertCard();
        atm.enterPin("1234");
        assertEquals("PIN Entered", atm.getState().getName());
    }

    @Test
    public void testEnterIncorrectPin() {
        atm.insertCard();
        atm.enterPin("5335");
        assertEquals("Card Inserted", atm.getState().getName());
        atm.enterPin("7252");
        assertEquals("Card Inserted", atm.getState().getName());
        atm.enterPin("7436");
        assertEquals("No Card", atm.getState().getName());
    }

    @Test
    public void testWithdrawCashWithCorrectPin() {
        atm.insertCard();
        atm.enterPin("1234");
        atm.withdrawCash(500);
        assertEquals("No Card", atm.getState().getName());
        assertEquals(500, atm.getBalance());
    }

    @Test
    public void testWithdrawCashWithInsufficientBalance() {
        atm.insertCard();
        atm.enterPin("1234");
        atm.withdrawCash(1500);
        assertEquals("PIN Entered", atm.getState().getName());
        assertEquals(1000, atm.getBalance());
    }

    @Test
    public void testWithdrawCashWithoutEnteringPin() {
        atm.insertCard();
        atm.withdrawCash(200);
        assertEquals("Card Inserted", atm.getState().getName());
        assertEquals(1000, atm.getBalance());
    }

    @Test
    public void testMultipleCardInsertions() {
        atm.insertCard();
        atm.insertCard();
        assertEquals("Card Inserted", atm.getState().getName());
    }

    @Test
    public void testEjectingCardWhileNoCardIsInserted() {
        atm.ejectCard();
        assertEquals("No Card", atm.getState().getName());
    }
}
