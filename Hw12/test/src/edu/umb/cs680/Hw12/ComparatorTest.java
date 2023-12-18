package edu.umb.cs680.Hw12;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {
    private List<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("Car1", "Model1", 2001, 105000, 302000));
        cars.add(new Car("Car2", "Model2", 1823, 50693, 293343));
        cars.add(new Car("Car3", "Model3", 1933, 14224, 326000));
        cars.add(new Car("Car4", "Model4", 2005, 38344, 91731234));
        cars.add(new Car("Car5", "Model5", 1993, 33122, 926300));
        cars.add(new Car("Car6", "Model6", 2024, 18300, 138334));
    }

    @Test
    public void testMileageComparator() {
        Collections.sort(cars, new MileageComparator());
        assertEquals("Car3", cars.get(0).getMake());
        assertEquals("Car6", cars.get(1).getMake());
        assertEquals("Car5", cars.get(2).getMake());
        assertEquals("Car4", cars.get(3).getMake());
        assertEquals("Car2", cars.get(4).getMake());
        assertEquals("Car1", cars.get(5).getMake());
    }


    @Test
    public void testPriceComparator() {
        Collections.sort(cars, new PriceComparator());
        assertEquals("Car6", cars.get(0).getMake());
        assertEquals("Car2", cars.get(1).getMake());
        assertEquals("Car1", cars.get(2).getMake());
        assertEquals("Car3", cars.get(3).getMake());
        assertEquals("Car5", cars.get(4).getMake());
        assertEquals("Car4", cars.get(5).getMake());
    }

    @Test
    public void testYearComparator() {
        Collections.sort(cars, new YearComparator());
        assertEquals("Car6", cars.get(0).getMake());
        assertEquals("Car4", cars.get(1).getMake());
        assertEquals("Car1", cars.get(2).getMake());
        assertEquals("Car5", cars.get(3).getMake());
        assertEquals("Car3", cars.get(4).getMake());
        assertEquals("Car2", cars.get(5).getMake());
    }

    @Test
    public void testParetoComparator() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, new ParetoComparator(cars));
        assertEquals("Car3", cars.get(0).getMake());
        assertEquals("Car4", cars.get(1).getMake());
        assertEquals("Car5", cars.get(2).getMake());
        assertEquals("Car6", cars.get(3).getMake());
        assertEquals("Car1", cars.get(4).getMake());
        assertEquals("Car2", cars.get(5).getMake());
    }
}
