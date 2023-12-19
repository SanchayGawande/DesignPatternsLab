package edu.umb.cs680.Hw06;

import java.util.ArrayList;
import java.util.List;

public class LocationSensor {
    private List<LocationObserver> observers;
    private Location currentLocation;

    public LocationSensor() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(LocationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LocationObserver observer) {
        observers.remove(observer);
    }

    public void updateLocation(double latitude, double longitude) {
        this.currentLocation = new Location(latitude, longitude);
        notifyObservers();
    }

    public void updateLocation(Location newLocation) {
        if (newLocation != null) {
            this.currentLocation = newLocation;
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (LocationObserver observer : observers) {
            observer.updateLocation(currentLocation);
        }
    }
}
