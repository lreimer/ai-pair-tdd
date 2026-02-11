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
    void shouldReturn1ForInput1() {
        assertEquals("I", romanNumerals.convert(1));
    }

    @Test
    void shouldReturnIIForInput2() {
        assertEquals("II", romanNumerals.convert(2));
    }

    @Test
    void shouldReturnIVForInput4() {
        assertEquals("IV", romanNumerals.convert(4));
    }

    @Test
    void shouldReturnVForInput5() {
        assertEquals("V", romanNumerals.convert(5));
    }

    @Test
    void shouldReturnIXForInput9() {
        assertEquals("IX", romanNumerals.convert(9));
    }

    @Test
    void shouldReturnXForInput10() {
        assertEquals("X", romanNumerals.convert(10));
    }

    @Test
    void shouldReturnXLIIForInput42() {
        assertEquals("XLII", romanNumerals.convert(42));
    }

    @Test
    void shouldReturnXCIXForInput99() {
        assertEquals("XCIX", romanNumerals.convert(99));
    }

    @Test
    void shouldReturnMMXIIIForInput2013() {
        assertEquals("MMXIII", romanNumerals.convert(2013));
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
