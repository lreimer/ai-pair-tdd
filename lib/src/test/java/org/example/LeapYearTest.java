package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {
    private LeapYear leapYear;

    @BeforeEach
    void setUp() {
        leapYear = new LeapYear();
    }

    @ParameterizedTest
    @DisplayName("Should identify common years divisible by 4 as leap years")
    @ValueSource(ints = {4, 8, 1996, 2004, 2024, 2028})
    void shouldReturnTrueForYearsDivisibleBy4(int year) {
        assertTrue(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @DisplayName("Should identify years not divisible by 4 as non-leap years")
    @ValueSource(ints = {1, 2, 3, 1997, 2023, 2025, 2026})
    void shouldReturnFalseForYearsNotDivisibleBy4(int year) {
        assertFalse(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @DisplayName("Should identify century years not divisible by 400 as non-leap years")
    @ValueSource(ints = {1700, 1800, 1900, 2100, 2200, 2300})
    void shouldReturnFalseForCenturyYearsNotDivisibleBy400(int year) {
        assertFalse(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @DisplayName("Should identify century years divisible by 400 as leap years")
    @ValueSource(ints = {400, 800, 1200, 1600, 2000, 2400})
    void shouldReturnTrueForCenturyYearsDivisibleBy400(int year) {
        assertTrue(leapYear.isLeapYear(year));
    }

    @ParameterizedTest
    @DisplayName("Should throw exception for invalid input")
    @ValueSource(ints = {0, -1, -100, -2024})
    void shouldThrowExceptionForInvalidInput(int invalidYear) {
        assertThrows(IllegalArgumentException.class, () -> leapYear.isLeapYear(invalidYear));
    }
}
