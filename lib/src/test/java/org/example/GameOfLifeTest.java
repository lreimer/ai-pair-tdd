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

    @Test
    void shouldMatchAcceptanceCriteria() {
        // Generation 1: 4x8 grid
        // ........
        // ....*...
        // ...**...
        // ........
        boolean[][] grid = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, true, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, false, false, false, false, false}
        };
        
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        // Expected Generation 2:
        // ........
        // ...**...
        // ...**...
        // ........
        boolean[][] expected = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, false, false, false, false, false}
        };
        
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], nextGen[i], "Row " + i + " mismatch");
        }
    }

    @Test
    void shouldHandleHorizontalBlinker() {
        // Horizontal line
        // .....
        // .***. 
        // .....
        boolean[][] grid = {
            {false, false, false, false, false},
            {false, true, true, true, false},
            {false, false, false, false, false}
        };
        
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        // Should become vertical
        // ..*..
        // ..*..
        // ..*..
        assertFalse(nextGen[0][1]);
        assertTrue(nextGen[0][2]);
        assertFalse(nextGen[0][3]);
        
        assertFalse(nextGen[1][1]);
        assertTrue(nextGen[1][2]);
        assertFalse(nextGen[1][3]);
        
        assertFalse(nextGen[2][1]);
        assertTrue(nextGen[2][2]);
        assertFalse(nextGen[2][3]);
    }

    @Test
    void shouldHandleDeathAtEdge() {
        // Cell at edge with < 2 neighbors should die
        boolean[][] grid = {
            {true, false, false},
            {false, true, false},
            {false, false, false}
        };
        
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        // Both cells should die due to underpopulation
        assertFalse(nextGen[0][0]);
        assertFalse(nextGen[1][1]);
    }

    @Test
    void shouldHandleBirthAtEdge() {
        // Three cells forming L-shape at edge
        boolean[][] grid = {
            {true, true, false},
            {true, false, false},
            {false, false, false}
        };
        
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        // A new cell should be born at [1][1] (3 neighbors)
        assertTrue(nextGen[1][1]);
        // Corner cells should survive (2-3 neighbors)
        assertTrue(nextGen[0][0]);
    }

    @Test
    void shouldHandleOvercrowding() {
        // 5 cells in X pattern - center should die
        boolean[][] grid = {
            {false, false, false, false, false},
            {false, true, false, true, false},
            {false, false, true, false, false},
            {false, true, false, true, false},
            {false, false, false, false, false}
        };
        
        boolean[][] nextGen = gameOfLife.nextGeneration(grid);
        
        // Center cell has 4 neighbors, should die from overcrowding
        assertFalse(nextGen[2][2]);
    }
}
