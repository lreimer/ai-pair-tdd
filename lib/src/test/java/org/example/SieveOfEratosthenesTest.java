package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SieveOfEratosthenesTest {
    private SieveOfEratosthenes sieve;

    @BeforeEach
    void setUp() {
        sieve = new SieveOfEratosthenes();
    }

    @Test
    @DisplayName("Should return single prime 2 for n=2")
    void shouldReturnSinglePrime2ForN2() {
        List<Integer> result = sieve.findPrimes(2);
        assertEquals(List.of(2), result);
    }

    @Test
    @DisplayName("Should return empty list for n=0")
    void shouldReturnEmptyListForN0() {
        List<Integer> result = sieve.findPrimes(0);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should return empty list for n=1")
    void shouldReturnEmptyListForN1() {
        List<Integer> result = sieve.findPrimes(1);
        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @DisplayName("Should throw exception for negative input")
    @ValueSource(ints = {-1, -10, -100})
    void shouldThrowExceptionForNegativeInput(int n) {
        assertThrows(IllegalArgumentException.class, () -> sieve.findPrimes(n));
    }

    @Test
    @DisplayName("Should find all primes up to 10")
    void shouldFindAllPrimesUpTo10() {
        List<Integer> result = sieve.findPrimes(10);
        assertEquals(List.of(2, 3, 5, 7), result);
    }

    @Test
    @DisplayName("Should find all primes up to 30")
    void shouldFindAllPrimesUpTo30() {
        List<Integer> result = sieve.findPrimes(30);
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), result);
    }

    @ParameterizedTest
    @DisplayName("Should find correct number of primes for various inputs")
    @CsvSource({
        "2, 1",
        "3, 2",
        "5, 3",
        "10, 4",
        "20, 8",
        "50, 15",
        "100, 25"
    })
    void shouldFindCorrectNumberOfPrimes(int n, int expectedCount) {
        List<Integer> result = sieve.findPrimes(n);
        assertEquals(expectedCount, result.size());
    }

    @Test
    @DisplayName("Should handle large input efficiently")
    void shouldHandleLargeInputEfficiently() {
        List<Integer> result = sieve.findPrimes(1000);
        assertFalse(result.isEmpty());
        assertEquals(2, result.get(0)); // First prime should be 2
        assertEquals(997, result.get(result.size() - 1)); // Last prime up to 1000 is 997
    }

    @Test
    @DisplayName("Example usage demonstration")
    void exampleUsageDemonstration() {
        // This test demonstrates typical usage patterns of the Sieve of Eratosthenes
        SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        
        // Find all primes up to 50
        List<Integer> primes = sieve.findPrimes(50);
        
        // Verify the results contain expected primes
        assertTrue(primes.contains(2));
        assertTrue(primes.contains(3));
        assertTrue(primes.contains(47));
        
        // Verify non-primes are not included
        assertFalse(primes.contains(4));
        assertFalse(primes.contains(50));
        
        // Display usage example (visible in test output)
        System.out.println("=== Example Usage ===");
        System.out.println("Finding primes up to 50: " + primes);
        System.out.println("Total primes found: " + primes.size());
    }
}
