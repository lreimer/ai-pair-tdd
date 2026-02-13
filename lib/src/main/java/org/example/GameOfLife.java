package org.example;

public class GameOfLife {

    private static final int DEAD = 0;
    private static final int ALIVE = 1;

    public int[][] nextGeneration(int[][] grid) {
        if (grid.length == 0) {
            return new int[0][0];
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] newGrid = new int[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = countLiveNeighbors(grid, row, col);
                newGrid[row][col] = getNextCellState(grid[row][col], liveNeighbors);
            }
        }
        
        return newGrid;
    }
    
    private int getNextCellState(int currentCell, int liveNeighbors) {
        if (isAlive(currentCell)) {
            return survives(liveNeighbors) ? ALIVE : DEAD;
        } else {
            return becomesAlive(liveNeighbors) ? ALIVE : DEAD;
        }
    }
    
    private boolean isAlive(int cell) {
        return cell == ALIVE;
    }
    
    private boolean survives(int liveNeighbors) {
        return liveNeighbors == 2 || liveNeighbors == 3;
    }
    
    private boolean becomesAlive(int liveNeighbors) {
        return liveNeighbors == 3;
    }
    
    private int countLiveNeighbors(int[][] grid, int row, int col) {
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
                    count += grid[neighborRow][neighborCol];
                }
            }
        }
        
        return count;
    }
    
    private boolean isWithinBounds(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
