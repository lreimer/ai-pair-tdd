package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrimeFactorsTest {

    private PrimeFactors primeFactors;

    @BeforeEach
    void setUp() {
        primeFactors = new PrimeFactors();
    }

    @ParameterizedTest
    @DisplayName("Should return an empty list for 1")
    @ValueSource(ints = {1})
    void shouldReturnEmptyListForOne(int number) {
        assertEquals(Collections.emptyList(), primeFactors.generate(number));
    }

    @ParameterizedTest
    @DisplayName("Should return the number itself for primes")
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 97})
    void shouldReturnSingletonForPrimes(int prime) {
        assertEquals(List.of(prime), primeFactors.generate(prime));
    }

    @ParameterizedTest
    @DisplayName("Should compute the prime factorization of composite numbers")
    @CsvSource({
        "4,    '2,2'",
        "6,    '2,3'",
        "8,    '2,2,2'",
        "9,    '3,3'",
        "12,   '2,2,3'",
        "15,   '3,5'",
        "16,   '2,2,2,2'",
        "30,   '2,3,5'",
        "60,   '2,2,3,5'",
        "100,  '2,2,5,5'",
        "2310, '2,3,5,7,11'"
    })
    void shouldFactorizeCompositeNumbers(int number, String expectedCsv) {
        List<Integer> expected = Stream.of(expectedCsv.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .toList();
        assertEquals(expected, primeFactors.generate(number));
    }

    @ParameterizedTest
    @DisplayName("Product of the factors equals the original number")
    @ValueSource(ints = {2, 4, 6, 12, 17, 49, 100, 360, 1024, 999_983})
    void productOfFactorsEqualsInput(int number) {
        long product = primeFactors.generate(number).stream()
                .mapToLong(Integer::longValue)
                .reduce(1L, (a, b) -> a * b);
        assertEquals(number, product);
    }

    @ParameterizedTest
    @DisplayName("Should throw exception for non-positive input")
    @ValueSource(ints = {0, -1, -2, -100, Integer.MIN_VALUE})
    void shouldThrowExceptionForNonPositiveInput(int invalid) {
        assertThrows(IllegalArgumentException.class, () -> primeFactors.generate(invalid));
    }

    @Test
    @DisplayName("Should factorize a large highly composite number")
    void shouldFactorizeLargeHighlyCompositeNumber() {
        // 2^10 * 3^5 = 1024 * 243 = 248_832
        List<Integer> expected = Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3);
        assertEquals(expected, primeFactors.generate(248_832));
    }
}
