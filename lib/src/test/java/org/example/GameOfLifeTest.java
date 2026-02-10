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
    void shouldReturnEmptyGridWhenAllCellsAreDead() {
        boolean[][] grid = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldKillLiveCellWithFewerThanTwoNeighbors() {
        boolean[][] grid = {
            {false, false, false},
            {false, true, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldKeepLiveCellWithTwoNeighborsAlive() {
        boolean[][] grid = {
            {true, true, false},
            {false, true, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {true, true, false},
            {true, true, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldKeepLiveCellWithThreeNeighborsAlive() {
        boolean[][] grid = {
            {true, true, false},
            {true, true, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {true, true, false},
            {true, true, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldKillLiveCellWithMoreThanThreeNeighbors() {
        boolean[][] grid = {
            {true, true, true},
            {true, true, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {true, false, true},
            {true, false, true},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldBringDeadCellToLifeWithExactlyThreeNeighbors() {
        boolean[][] grid = {
            {true, true, false},
            {true, false, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {true, true, false},
            {true, true, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldHandleAcceptanceCriteriaExample() {
        boolean[][] grid = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, false, true, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, false, false, false, false, false}
        };
        boolean[][] expected = {
            {false, false, false, false, false, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, true, true, false, false, false},
            {false, false, false, false, false, false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldHandleBirthsAtTopEdge() {
        boolean[][] grid = {
            {false, true, false},
            {true, true, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {true, true, false},
            {true, true, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldHandleDeathsAtBottomEdge() {
        boolean[][] grid = {
            {false, false, false},
            {false, false, false},
            {false, true, false}
        };
        boolean[][] expected = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldHandleBirthsAtLeftEdge() {
        boolean[][] grid = {
            {true, false, false},
            {true, false, false},
            {true, false, false}
        };
        boolean[][] expected = {
            {false, false, false},
            {true, true, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldHandleDeathsAtRightEdge() {
        boolean[][] grid = {
            {false, false, true},
            {false, false, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }

    @Test
    void shouldHandleCornerCells() {
        boolean[][] grid = {
            {true, true, false},
            {true, false, false},
            {false, false, false}
        };
        boolean[][] expected = {
            {true, true, false},
            {true, true, false},
            {false, false, false}
        };
        assertArrayEquals(expected, game.nextGeneration(grid));
    }
}
