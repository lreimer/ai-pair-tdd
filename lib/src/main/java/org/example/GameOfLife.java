package org.example;

/**
 * Implementation of Conway's Game of Life.
 * <p>
 * The Game of Life is a cellular automaton devised by mathematician John Conway.
 * It consists of a grid of cells that evolve through generations based on simple rules.
 * </p>
 */
public class GameOfLife {
    
    /**
     * Calculates the next generation of the grid based on Conway's Game of Life rules.
     * <p>
     * Rules:
     * <ul>
     *   <li>Any live cell with fewer than two live neighbours dies (underpopulation)</li>
     *   <li>Any live cell with two or three live neighbours survives</li>
     *   <li>Any live cell with more than three live neighbours dies (overcrowding)</li>
     *   <li>Any dead cell with exactly three live neighbours becomes alive (reproduction)</li>
     * </ul>
     * </p>
     *
     * @param grid the current generation grid where true represents a live cell
     * @return the next generation grid
     */
    public boolean[][] nextGeneration(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] newGrid = new boolean[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(grid, row, col);
                newGrid[row][col] = shouldCellBeAlive(grid[row][col], liveNeighbors);
            }
        }
        
        return newGrid;
    }
    
    private boolean shouldCellBeAlive(boolean isAlive, int liveNeighbors) {
        if (isAlive) {
            return liveNeighbors == 2 || liveNeighbors == 3;
        } else {
            return liveNeighbors == 3;
        }
    }
    
    private int countLiveNeighbors(boolean[][] grid, int row, int col) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int neighborRow = row + i;
                int neighborCol = col + j;
                
                if (isWithinBounds(neighborRow, neighborCol, rows, cols)) {
                    if (grid[neighborRow][neighborCol]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean isWithinBounds(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
