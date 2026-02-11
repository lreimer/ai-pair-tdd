package org.example;

public class GameOfLife {

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
                int currentCell = grid[row][col];
                
                if (currentCell == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        newGrid[row][col] = 1;
                    } else {
                        newGrid[row][col] = 0;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        newGrid[row][col] = 1;
                    } else {
                        newGrid[row][col] = 0;
                    }
                }
            }
        }
        
        return newGrid;
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
                
                int newRow = row + i;
                int newCol = col + j;
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    count += grid[newRow][newCol];
                }
            }
        }
        
        return count;
    }
}
