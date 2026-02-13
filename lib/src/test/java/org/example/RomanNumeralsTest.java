package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {
    private RomanNumerals romanNumerals;

    @BeforeEach
    void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @Test
    void shouldConvert1ToI() {
        assertEquals("I", romanNumerals.convert(1));
    }

    @Test
    void shouldConvert2ToII() {
        assertEquals("II", romanNumerals.convert(2));
    }

    @Test
    void shouldConvert4ToIV() {
        assertEquals("IV", romanNumerals.convert(4));
    }

    @Test
    void shouldConvert5ToV() {
        assertEquals("V", romanNumerals.convert(5));
    }

    @Test
    void shouldConvert9ToIX() {
        assertEquals("IX", romanNumerals.convert(9));
    }

    @Test
    void shouldConvert10ToX() {
        assertEquals("X", romanNumerals.convert(10));
    }

    @Test
    void shouldConvert42ToXLII() {
        assertEquals("XLII", romanNumerals.convert(42));
    }

    @Test
    void shouldConvert99ToXCIX() {
        assertEquals("XCIX", romanNumerals.convert(99));
    }

    @Test
    void shouldConvert2013ToMMXIII() {
        assertEquals("MMXIII", romanNumerals.convert(2013));
    }

    @Test
    void shouldConvert3ToIII() {
        assertEquals("III", romanNumerals.convert(3));
    }

    @Test
    void shouldConvert50ToL() {
        assertEquals("L", romanNumerals.convert(50));
    }

    @Test
    void shouldConvert100ToC() {
        assertEquals("C", romanNumerals.convert(100));
    }

    @Test
    void shouldConvert500ToD() {
        assertEquals("D", romanNumerals.convert(500));
    }

    @Test
    void shouldConvert1000ToM() {
        assertEquals("M", romanNumerals.convert(1000));
    }

    @Test
    void shouldConvert3999ToMMMCMXCIX() {
        assertEquals("MMMCMXCIX", romanNumerals.convert(3999));
    }

    @Test
    void shouldThrowExceptionForZero() {
        assertThrows(IllegalArgumentException.class, () -> romanNumerals.convert(0));
    }

    @Test
    void shouldThrowExceptionForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> romanNumerals.convert(-1));
    }

    @Test
    void shouldThrowExceptionForNumberGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> romanNumerals.convert(4000));
    }
}
