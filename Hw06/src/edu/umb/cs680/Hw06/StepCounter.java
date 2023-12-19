package edu.umb.cs680.Hw06;

import java.util.ArrayList;
import java.util.List;

public class StepCounter {
    private List<StepCountObserver> observers;
    private int steps;

    public StepCounter() {
        this.observers = new ArrayList<>();
        this.steps = 0;
    }

    public void addObserver(StepCountObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StepCountObserver observer) {
        observers.remove(observer);
    }

    public void incrementStep() {
        steps++;
        notifyObservers();
    }

    public void incrementSteps(int stepCount) {
        if (stepCount > 0) {
            steps += stepCount;
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (StepCountObserver observer : observers) {
            observer.updateStepCount(new StepCount(steps));
        }
    }
}
