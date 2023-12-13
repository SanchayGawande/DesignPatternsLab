package edu.umb.cs680.Hw11;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DistanceTest {
    private static List<List<Double>> normalizedValues;
    private static Euclidean euclidean;
    private static Manhattan manhattan;
    private static Cosine cosine;

    @BeforeAll
    static void setUp() {
        euclidean = new Euclidean();
        manhattan = new Manhattan();
        cosine = new Cosine();

        normalizedValues = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int mileage = random.nextInt(400000);
            int year = 2000 + random.nextInt(34);
            float price = 10000 + random.nextFloat() * 60000;
            List<Double> temp = Car.normalizeCarValues(mileage, year, price);
            normalizedValues.add(temp);
        }
    }

    @Test
    void testEuclideanDistanceMetric() {
        for (int i = 0; i < normalizedValues.size() - 1; i++) {
            double distance = euclidean.distance(normalizedValues.get(i), normalizedValues.get(i + 1));
            assertTrue(distance >= 0);
        }
    }

    @Test
    void testManhattanDistanceMetric() {
        for (int i = 0; i < normalizedValues.size() - 1; i++) {
            double distance = manhattan.distance(normalizedValues.get(i), normalizedValues.get(i + 1));
            assertTrue(distance >= 0);
        }
    }

    @Test
    void testCosineDistanceMetric() {
        for (int i = 0; i < normalizedValues.size() - 1; i++) {
            double distance = cosine.distance(normalizedValues.get(i), normalizedValues.get(i + 1));
            assertTrue(distance >= 0 && distance <= 1);
        }
    }
}
