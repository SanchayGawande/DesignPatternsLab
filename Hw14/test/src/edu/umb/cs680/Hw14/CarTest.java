package edu.umb.cs680.Hw14;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private ArrayList<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("Car1", "Model1", 2001, 105000, 302000));
        cars.add(new Car("Car2", "Model2", 1823, 50693, 293343));
        cars.add(new Car("Car3", "Model3", 1933, 14224, 326000));
        cars.add(new Car("Car4", "Model4", 2005, 38344, 973123));
        cars.add(new Car("Car5", "Model5", 1993, 33122, 926300));
        cars.add(new Car("Car6", "Model6", 2024, 18300, 138334));
    }

    @Test
    public void testMileageComparatorAscending() {
        Collections.sort(cars, (car1, car2) -> Integer.compare(car1.getMileage(), car2.getMileage()));
        assertTrue(cars.get(0).getMileage() <= cars.get(1).getMileage());
    }

    @Test
    public void testMileageComparatorDescending() {
        Collections.sort(cars, (car1, car2) -> Integer.compare(car2.getMileage(), car1.getMileage()));
        assertTrue(cars.get(0).getMileage() >= cars.get(1).getMileage());
    }

    @Test
    public void testMileageComparatorWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));
        assertTrue(cars.get(0).getMileage() <= cars.get(1).getMileage());
    }

    @Test
    public void testMileageComparatorDescendingWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage).reversed());
        assertTrue(cars.get(0).getMileage() >= cars.get(1).getMileage());
    }


    @Test
    public void testPriceComparatorAscending() {
        Collections.sort(cars, (car1, car2) -> Float.compare(car1.getPrice(), car2.getPrice()));
        assertTrue(cars.get(0).getPrice() <= cars.get(1).getPrice());
    }

    @Test
    public void testPriceComparatorDescending() {
        Collections.sort(cars, (car1, car2) -> Float.compare(car2.getPrice(), car1.getPrice()));
        assertTrue(cars.get(0).getPrice() >= cars.get(1).getPrice());
    }

    @Test
    public void testPriceComparatorWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));
        assertTrue(cars.get(0).getPrice() <= cars.get(1).getPrice());
    }

    @Test
    public void testPriceComparatorDescendingWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice).reversed());
        assertTrue(cars.get(0).getPrice() >= cars.get(1).getPrice());
    }

    @Test
    public void testYearComparatorAscending() {
        Collections.sort(cars, (car1, car2) -> Integer.compare(car1.getYear(), car2.getYear()));
        assertTrue(cars.get(0).getYear() <= cars.get(1).getYear());
    }

    @Test
    public void testYearComparatorDescending() {
        Collections.sort(cars, (car1, car2) -> Integer.compare(car2.getYear(), car1.getYear()));
        assertTrue(cars.get(0).getYear() >= cars.get(1).getYear());
    }

    @Test
    public void testYearComparatorWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingInt(Car::getYear));
        assertTrue(cars.get(0).getYear() <= cars.get(1).getYear());
    }

    @Test
    public void testYearComparatorDescendingWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingInt(Car::getYear).reversed());
        assertTrue(cars.get(0).getYear() >= cars.get(1).getYear());
    }

    @Test
    public void testParetoComparatorWithComparatorComparing() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount));
        assertTrue(cars.get(0).getDominationCount() <= cars.get(1).getDominationCount());
    }

    @Test
    public void testParetoComparatorWithComparatorComparingReversed() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount).reversed());
        assertTrue(cars.get(0).getDominationCount() >= cars.get(1).getDominationCount());
    }
}
