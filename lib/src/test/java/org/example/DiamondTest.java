package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiamondTest {
    private Diamond diamond;

    @BeforeEach
    void setUp() {
        diamond = new Diamond();
    }

    @Test
    @DisplayName("Should return 'A' for input 'A'")
    void shouldReturnAForInputA() {
        assertEquals("A", diamond.print('A'));
    }

    @Test
    @DisplayName("Should return diamond for input 'B'")
    void shouldReturnDiamondForInputB() {
        String expected = " A\n" +
                          "B B\n" +
                          " A";
        assertEquals(expected, diamond.print('B'));
    }

    @Test
    @DisplayName("Should return diamond for input 'C'")
    void shouldReturnDiamondForInputC() {
        String expected = "  A\n" +
                          " B B\n" +
                          "C   C\n" +
                          " B B\n" +
                          "  A";
        assertEquals(expected, diamond.print('C'));
    }

    @Test
    @DisplayName("Should throw exception for non-alphabetic character")
    void shouldThrowExceptionForNonAlphabeticCharacter() {
        assertThrows(IllegalArgumentException.class, () -> diamond.print('1'));
        assertThrows(IllegalArgumentException.class, () -> diamond.print('@'));
        assertThrows(IllegalArgumentException.class, () -> diamond.print(' '));
    }

    @Test
    @DisplayName("Should support lowercase letters")
    void shouldSupportLowercaseLetters() {
        assertEquals("A", diamond.print('a'));
        String expected = " A\n" +
                          "B B\n" +
                          " A";
        assertEquals(expected, diamond.print('b'));
    }

    @Test
    @DisplayName("Should return diamond for input 'Z'")
    void shouldReturnDiamondForInputZ() {
        String result = diamond.print('Z');
        assertNotNull(result);
        assertTrue(result.startsWith("                         A"));
        assertTrue(result.contains("Z"));
    }
}
