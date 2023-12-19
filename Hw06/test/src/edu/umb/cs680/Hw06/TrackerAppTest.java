package edu.umb.cs680.Hw06;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrackerAppTest {
    private LocationSensor locationSensor;
    private StepCounter stepCounter;
    private TrackerApp trackerApp;

    @BeforeEach
    void setUp() {
        locationSensor = new LocationSensor();
        stepCounter = new StepCounter();
        trackerApp = new TrackerApp();

        locationSensor.addObserver(trackerApp);
        stepCounter.addObserver(trackerApp);
    }

    @Test
    void verifyInitialLocation() {
        Location initialLocation = trackerApp.getlastLocation();
        assertEquals(0.0, initialLocation.getLatitude());
        assertEquals(0.0, initialLocation.getLongitude());
    }

    @Test
    void verifyLocationUpdate() {
        double latitude = 42.3129;
        double longitude = -71.0384; // UMB coordinates
        locationSensor.updateLocation(latitude, longitude);
        Location lastLocation = trackerApp.getlastLocation();
        assertNotNull(lastLocation);
        assertEquals(latitude, lastLocation.getLatitude());
        assertEquals(longitude, lastLocation.getLongitude());
    }

    @Test
    void verifyInitialStepCount() {
        assertEquals(0, trackerApp.getTotalSteps());
    }

    @Test
    void verifyStepCountUpdate() {
        stepCounter.incrementStep();
        assertEquals(1, trackerApp.getTotalSteps());
    }

    @Test
    void verifyMultipleStepCountUpdates() {
        for (int i = 0; i < 7; i++) {
            stepCounter.incrementStep();
        }
        assertEquals(7, trackerApp.getTotalSteps());
    }

    @Test
    void verifyObserversAfterRemoval() {
        locationSensor.removeObserver(trackerApp);
        stepCounter.removeObserver(trackerApp);
        locationSensor.updateLocation(42.3129, -71.0384);
        stepCounter.incrementStep();
        Location lastLocation = trackerApp.getlastLocation();
        assertEquals(0.0, lastLocation.getLatitude());
        assertEquals(0.0, lastLocation.getLongitude());
        assertEquals(0, trackerApp.getTotalSteps());
    }
}
