package edu.umb.cs680.Hw12;

import java.util.Comparator;
import java.util.List;

public class ParetoComparator implements Comparator<Car> {
    public ParetoComparator(List<Car> cars) {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
    }

    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getDominationCount(), car2.getDominationCount());
    }
}
