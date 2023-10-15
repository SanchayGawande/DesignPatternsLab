package edu.umb.cs680.Hw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    public void testPrimeGeneration() {
        PrimeGenerator gen = new PrimeGenerator(1, 20);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void testPrimeGenerationWithLargeRange() {
        PrimeGenerator gen = new PrimeGenerator(100, 180);
        gen.generatePrimes();
        Long[] expectedPrimes = {101L, 103L, 107L, 109L, 113L, 127L, 131L, 137L, 139L, 149L, 151L, 157L, 163L, 167L, 173L, 179L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void testPrimeGenerationNegativeCase() {
        try {
            PrimeGenerator gen = new PrimeGenerator(-100, 100);
            gen.generatePrimes();
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=-100 to=100", e.getMessage());
        }
    }

    @Test
    public void testPrimeGenerationInvalidCase() {
        try {
            PrimeGenerator gen = new PrimeGenerator(100, 10);
            gen.generatePrimes();
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=100 to=10", e.getMessage());
        }
    }
}
