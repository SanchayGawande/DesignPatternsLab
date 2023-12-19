package edu.umb.cs680.Hw06;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StepCounterTest {
    private StepCounter stepCounter;
    private TrackerApp trackerApp;

    @BeforeEach
    void setUp() {
        stepCounter = new StepCounter();
        trackerApp = new TrackerApp();
        stepCounter.addObserver(trackerApp);
    }

    @Test
    void verifyStepIncrement() {
        stepCounter.incrementStep();
        assertEquals(1, trackerApp.getTotalSteps());
    }

    @Test
    void verifyRemovalObserver() {
        stepCounter.removeObserver(trackerApp);
        stepCounter.incrementStep();
        assertEquals(0, trackerApp.getTotalSteps());
    }

    @Test
    void verifyMultipleObservers() {
        TrackerApp anotherTrackerApp = new TrackerApp();
        stepCounter.addObserver(anotherTrackerApp);
        stepCounter.incrementStep();
        assertEquals(1, trackerApp.getTotalSteps());
        assertEquals(1, anotherTrackerApp.getTotalSteps());
    }

    @Test
    void verifyStepIncrementSpecificNoOfSteps() {
        stepCounter.incrementSteps(3);
        assertEquals(3, trackerApp.getTotalSteps());
    }
}
