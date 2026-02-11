package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private GameOfLife game;

    @BeforeEach
    void setUp() {
        game = new GameOfLife();
    }

    @Test
    void shouldReturnEmptyGridForEmptyInput() {
        int[][] emptyGrid = new int[0][0];
        int[][] nextGeneration = game.nextGeneration(emptyGrid);
        assertEquals(0, nextGeneration.length);
    }

    @Test
    void shouldReturnAllDeadCellsForGridWithOnlyDeadCells() {
        int[][] grid = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] nextGeneration = game.nextGeneration(grid);
        assertArrayEquals(expected, nextGeneration);
    }

    @Test
    void shouldKillLiveCellWithNoNeighborsDueToUnderpopulation() {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] nextGeneration = game.nextGeneration(grid);
        assertArrayEquals(expected, nextGeneration);
    }

    @Test
    void shouldKeepLiveCellWith2Neighbors() {
        int[][] grid = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        int[][] nextGeneration = game.nextGeneration(grid);
        assertArrayEquals(expected, nextGeneration);
    }
}
