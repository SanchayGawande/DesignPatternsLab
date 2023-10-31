package edu.umb.cs680.Hw04;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class FanContextTest {
    FanContext fan;

    @BeforeEach
    void setUp() {
        fan = new FanContext();
    }

    @Test
    void verifyInitialState() {
        assertEquals(fan.getState().getClass().getSimpleName(), "OffState");
    }

    @Test
    void testTurnOnFan() {
        fan.turnOn();
        assertEquals(fan.getState().getClass().getSimpleName(), "LowState");
    }

    @Test
    void testIncreaseSpeed() {
        fan.turnOn();
        fan.increaseSpeed();
        assertFalse(fan.getState() instanceof LowState);
        assertSame(MediumState.class, fan.getState().getClass());
    }

    @Test
    void testDecreaseSpeed() {
        fan.turnOn();
        fan.decreaseSpeed();
        assertEquals(fan.getState().getClass().getSimpleName(), "OffState");
    }

    @Test
    void testTurnOffFan() {
        fan.turnOn();
        fan.turnOff();
        assertEquals(fan.getState().getClass().getSimpleName(), "OffState");
    }

    @Test
    void testDisplayState() {
        fan.turnOn();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        fan.displayState();
        assertEquals("Fan is in LowState\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void testToggleSpeedFromLowToMedium() {
        fan.turnOn();
        fan.toggleSpeed();
        assertEquals(fan.getState().getClass().getSimpleName(), "MediumState");
    }

    @Test
    void testToggleSpeed() {
        fan.turnOn();
        fan.toggleSpeed();
        assertEquals(fan.getState().getClass().getSimpleName(), "MediumState");
        fan.toggleSpeed();
        assertEquals(fan.getState().getClass().getSimpleName(), "HighState");
        fan.toggleSpeed();
        assertEquals(fan.getState().getClass().getSimpleName(), "OffState");
    }

}