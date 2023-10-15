package edu.umb.cs680.Hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private String[] CarToStringArray(Car car) {
        String[] carInfo = {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
        return carInfo;
    }

    @Test
    void testCarEqualityWithModelYear() {
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car actual = new Car("Toyota", "RAV4", 2018);
        Car carNE = new Car("Honda", "HR-V", 2014);

        assertArrayEquals(expected, CarToStringArray(actual));
        assertNotEquals(expected, CarToStringArray(carNE));
    }
}

