package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiamondTest {
    private Diamond diamond;

    @BeforeEach
    void setUp() {
        diamond = new Diamond();
    }

    @Test
    void shouldReturnAForInputA() {
        assertEquals("A", diamond.print('A'));
    }

    @Test
    void shouldReturnDiamondForInputB() {
        String expected = " A\n" +
                          "B B\n" +
                          " A";
        assertEquals(expected, diamond.print('B'));
    }

    @Test
    void shouldReturnDiamondForInputC() {
        String expected = "  A\n" +
                          " B B\n" +
                          "C   C\n" +
                          " B B\n" +
                          "  A";
        assertEquals(expected, diamond.print('C'));
    }
}
