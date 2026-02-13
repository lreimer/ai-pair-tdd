package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {
    private RomanNumerals romanNumerals;

    @BeforeEach
    void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @ParameterizedTest
    @DisplayName("Should convert decimal numbers to Roman numerals")
    @CsvSource({
        "1, I",
        "2, II",
        "3, III",
        "4, IV",
        "5, V",
        "9, IX",
        "10, X",
        "42, XLII",
        "50, L",
        "99, XCIX",
        "100, C",
        "500, D",
        "1000, M",
        "2013, MMXIII",
        "3999, MMMCMXCIX"
    })
    void shouldConvertDecimalToRomanNumerals(int decimal, String expected) {
        assertEquals(expected, romanNumerals.convert(decimal));
    }

    @ParameterizedTest
    @DisplayName("Should throw exception for invalid input")
    @ValueSource(ints = {0, -1, -100, 4000, 5000})
    void shouldThrowExceptionForInvalidInput(int invalidNumber) {
        assertThrows(IllegalArgumentException.class, () -> romanNumerals.convert(invalidNumber));
    }
}
