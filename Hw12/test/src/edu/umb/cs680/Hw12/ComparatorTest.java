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
        cars.add(new Car("Car1", "Model1", 2023, 2000, 21000));
        cars.add(new Car("Car2", "Model2", 2022, 2500, 24000));
        cars.add(new Car("Car3", "Model3", 2021, 4000, 37000));
        cars.add(new Car("Car4", "Model4", 2020, 5000, 39000));
        cars.add(new Car("Car5", "Model4", 2015, 7000, 43000));
    }

    @Test
    public void testMileageComparator() {
        Collections.sort(cars, new MileageComparator());
        assertEquals("Car1", cars.get(0).getMake());
        assertEquals("Car2", cars.get(1).getMake());
        assertEquals("Car3", cars.get(2).getMake());
        assertEquals("Car4", cars.get(3).getMake());
        assertEquals("Car5", cars.get(4).getMake());
    }

    @Test
    public void testPriceComparator() {
        Collections.sort(cars, new PriceComparator());
        assertEquals("Car1", cars.get(0).getMake());
        assertEquals("Car2", cars.get(1).getMake());
        assertEquals("Car3", cars.get(2).getMake());
        assertEquals("Car4", cars.get(3).getMake());
        assertEquals("Car5", cars.get(4).getMake());

    }

    @Test
    public void testYearComparator() {
        Collections.sort(cars, new YearComparator());
        assertEquals("Car5", cars.get(0).getMake());
        assertEquals("Car4", cars.get(1).getMake());
        assertEquals("Car3", cars.get(2).getMake());
        assertEquals("Car2", cars.get(3).getMake());
        assertEquals("Car1", cars.get(4).getMake());
    }

    @Test
    public void testParetoComparator() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        assertEquals("Car1", cars.get(0).getMake());
        assertEquals("Car2", cars.get(1).getMake());
        assertEquals("Car3", cars.get(2).getMake());
        assertEquals("Car4", cars.get(3).getMake());
        assertEquals("Car5", cars.get(4).getMake());
    }

}
