package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private GameOfLife gameOfLife;

    @BeforeEach
    void setUp() {
        gameOfLife = new GameOfLife();
    }

    @Test
    void shouldReturnEmptyGridForEmptyInput() {
        boolean[][] grid = new boolean[3][3];
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        assertEquals(3, nextGen.length);
        assertEquals(3, nextGen[0].length);
        for (int i = 0; i < nextGen.length; i++) {
            for (int j = 0; j < nextGen[i].length; j++) {
                assertFalse(nextGen[i][j]);
            }
        }
    }

    @Test
    void shouldKillSingleCellDueToUnderpopulation() {
        boolean[][] grid = {
            {false, false, false},
            {false, true, false},
            {false, false, false}
        };
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        assertFalse(nextGen[1][1]);
    }

    @Test
    void shouldKeep2x2BlockAlive() {
        boolean[][] grid = {
            {false, false, false, false},
            {false, true, true, false},
            {false, true, true, false},
            {false, false, false, false}
        };
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        assertTrue(nextGen[1][1]);
        assertTrue(nextGen[1][2]);
        assertTrue(nextGen[2][1]);
        assertTrue(nextGen[2][2]);
    }
}
