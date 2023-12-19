package edu.umb.cs680.Hw06;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationSensorTest {
    private LocationSensor locationSensor;
    private TrackerApp trackerApp;

    @BeforeEach
    void setUp() {
        locationSensor = new LocationSensor();
        trackerApp = new TrackerApp();
        locationSensor.addObserver(trackerApp);
    }

    @Test
    void verifyLocationUpdateWithCoordinates() {
        double latitude = 42.3129;
        double longitude =  -71.0384; // UMB coordinates
        locationSensor.updateLocation(latitude, longitude);
        assertEquals(latitude, trackerApp.getlastLocation().getLatitude());
        assertEquals(longitude, trackerApp.getlastLocation().getLongitude());
    }

    @Test
    void verifyLocationUpdateWithLocationObject() {
        Location newLocation = new Location(40.7128, -74.0060); // New York coordinates
        locationSensor.updateLocation(newLocation);
        assertEquals(40.7128, trackerApp.getlastLocation().getLatitude());
        assertEquals(-74.0060, trackerApp.getlastLocation().getLongitude());
    }

}
