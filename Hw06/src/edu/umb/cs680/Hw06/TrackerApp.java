package edu.umb.cs680.Hw06;

public class TrackerApp implements LocationObserver, StepCountObserver {

    private Location lastLocation;
    private int totalSteps;
    
    public TrackerApp() {
        this.lastLocation = new Location(0.0, 0.0);
        this.totalSteps = 0;
    }

    @Override
    public void updateLocation(Location location) {
        this.lastLocation = location;
        displayLocation();
    }

    @Override
    public void updateStepCount(StepCount stepCount) {
        this.totalSteps = stepCount.getSteps();
        displayStepCount();
    }

    public Location getlastLocation() {
        return lastLocation;
    }

    public int getTotalSteps() {
        return totalSteps;
    }
    
    private void displayLocation() {
        System.out.println("Tracker App - Location updated: Latitude " + lastLocation.getLatitude()
                + ", Longitude " + lastLocation.getLongitude());
    }

    private void displayStepCount() {
        System.out.println("Tracker App - Step count updated: " + totalSteps + " steps");
    }

    public static void main(String[] args) {
    }
}
