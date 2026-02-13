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

    @Test
    void shouldKeepLiveCellWith3Neighbors() {
        int[][] grid = {
            {1, 1, 0},
            {1, 1, 0},
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

    @Test
    void shouldKillLiveCellWith4NeighborsDueToOvercrowding() {
        int[][] grid = {
            {1, 1, 1},
            {1, 1, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {1, 0, 1},
            {1, 0, 1},
            {0, 0, 0}
        };
        int[][] nextGeneration = game.nextGeneration(grid);
        assertArrayEquals(expected, nextGeneration);
    }

    @Test
    void shouldCreateLiveCellWhenDeadCellHas3Neighbors() {
        int[][] grid = {
            {1, 1, 0},
            {1, 0, 0},
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

    @Test
    void shouldMatchAcceptanceCriteriaExample() {
        int[][] generation1 = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int[][] generation2Expected = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int[][] generation2Actual = game.nextGeneration(generation1);
        assertArrayEquals(generation2Expected, generation2Actual);
    }

    @Test
    void shouldHandleBirthAtTopEdge() {
        int[][] grid = {
            {0, 1, 0},
            {1, 1, 0},
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

    @Test
    void shouldHandleDeathAtCorner() {
        int[][] grid = {
            {1, 0, 0},
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
    void shouldHandleBirthAtBottomRightCorner() {
        int[][] grid = {
            {0, 0, 0, 0},
            {0, 0, 0, 1},
            {0, 0, 1, 1}
        };
        int[][] expected = {
            {0, 0, 0, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
        };
        int[][] nextGeneration = game.nextGeneration(grid);
        assertArrayEquals(expected, nextGeneration);
    }

    @Test
    void shouldHandlePatternAtLeftEdge() {
        int[][] grid = {
            {1, 1, 0},
            {1, 0, 0},
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

    @Test
    void shouldHandleStillLifeBlockPattern() {
        int[][] grid = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        int[][] expected = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        int[][] nextGeneration = game.nextGeneration(grid);
        assertArrayEquals(expected, nextGeneration);
    }

    @Test
    void shouldHandleBlinkerOscillatorPattern() {
        int[][] generation1 = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0}
        };
        int[][] generation2 = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        int[][] actualGeneration2 = game.nextGeneration(generation1);
        assertArrayEquals(generation2, actualGeneration2);
        
        int[][] actualGeneration3 = game.nextGeneration(actualGeneration2);
        assertArrayEquals(generation1, actualGeneration3);
    }
}
