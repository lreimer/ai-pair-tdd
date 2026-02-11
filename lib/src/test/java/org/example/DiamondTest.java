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
}
