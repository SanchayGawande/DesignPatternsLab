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
        cars.add(new Car("Car1", "Model1", 2023, 2000, 21000));
        cars.add(new Car("Car2", "Model2", 2022, 2500, 24000));
        cars.add(new Car("Car3", "Model3", 2021, 4000, 37000));
        cars.add(new Car("Car4", "Model4", 2020, 5000, 39000));
        cars.add(new Car("Car5", "Model4", 2015, 7000, 43000));

    }

    @Test
    public void testMileageComparator() {
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));
        assertTrue(cars.get(0).getMileage() <= cars.get(1).getMileage());
        assertEquals("Car1", cars.get(0).getMake());
        assertEquals("Car2", cars.get(1).getMake());

    }

    @Test
    public void testMileageComparatorDescending() {
        Collections.sort(cars, (car1, car2) -> Integer.compare(car2.getMileage(), car1.getMileage()));
        assertTrue(cars.get(0).getMileage() >= cars.get(1).getMileage());
        assertEquals("Car5", cars.get(0).getMake());
    }

    @Test
    public void testMileageComparatorDescendingWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage).reversed());
        assertTrue(cars.get(0).getMileage() >= cars.get(1).getMileage());
    }

    @Test
    public void testPriceComparator() {
        Collections.sort(cars, (car1, car2) -> Float.compare(car1.getPrice(), car2.getPrice()));
        assertTrue(cars.get(0).getPrice() <= cars.get(1).getPrice());
    }

    @Test
    public void testPriceComparatorWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));
        assertTrue(cars.get(0).getPrice() <= cars.get(1).getPrice());
    }

    @Test
    public void testPriceComparatorDescending() {
        Collections.sort(cars, (car1, car2) -> Float.compare(car2.getPrice(), car1.getPrice()));
        assertTrue(cars.get(0).getPrice() >= cars.get(1).getPrice());
    }

    @Test
    public void testPriceComparatorDescendingWithComparatorComparing() {
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice).reversed());
        assertTrue(cars.get(0).getPrice() >= cars.get(1).getPrice());
    }

    @Test
    public void testYearComparatorAscending() {
        Collections.sort(cars, Comparator.comparingInt(Car::getYear));
        assertTrue(cars.get(0).getYear() <= cars.get(1).getYear());
    }

    @Test
    public void testYearComparatorReversed() {
        Collections.sort(cars, Comparator.comparingInt(Car::getYear).reversed());
        assertTrue(cars.get(0).getYear() >= cars.get(1).getYear());
    }

    @Test
    public void testParetoComparator() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount));
        assertEquals("Car1", cars.get(0).getMake());
        assertEquals("Car2", cars.get(1).getMake());
        assertEquals("Car3", cars.get(2).getMake());
        assertEquals("Car4", cars.get(3).getMake());
        assertEquals("Car5", cars.get(4).getMake());
    }

    @Test
    public void testParetoComparatorReversed() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount).reversed());
        assertEquals("Car5", cars.get(0).getMake());
        assertEquals("Car4", cars.get(1).getMake());
        assertEquals("Car3", cars.get(2).getMake());
        assertEquals("Car2", cars.get(3).getMake());
        assertEquals("Car1", cars.get(4).getMake());
    }
}