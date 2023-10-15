package edu.umb.cs680.Hw02;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class SingletonPrimeGeneratorTest {

    @Test
    public void testGetInstanceForNotNullValue() {
        SingletonPrimeGenerator generator = SingletonPrimeGenerator.getInstance(5, 50);
        Assertions.assertNotNull(generator);

    }

    @Test
    public void testIdenticalInstance() {
        SingletonPrimeGenerator generator1 = SingletonPrimeGenerator.getInstance(5, 50);
        SingletonPrimeGenerator generator2 = SingletonPrimeGenerator.getInstance(5, 50);
        Assertions.assertSame(generator1, generator2);

    }

    @Test
    void testGetPrimesIsWorking() {
        SingletonPrimeGenerator genPrimes = SingletonPrimeGenerator.getInstance(1, 100);
        genPrimes.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        assertIterableEquals(Arrays.asList(expectedPrimes), genPrimes.getPrimes());
    }

    @Test
    void testGivenWrongRanges() {

        try {
            SingletonPrimeGenerator genPrimes = SingletonPrimeGenerator.getInstance(-10, 10);
            genPrimes.generatePrimes();

        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=-10 to=10", ex.getMessage());
        }

        try {
            SingletonPrimeGenerator genPrimes = SingletonPrimeGenerator.getInstance(100, 1);
            genPrimes.generatePrimes();

        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=100 to=1", ex.getMessage());
        }
    }
}


