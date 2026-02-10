package org.example;

public class GameOfLife {

    public boolean[][] nextGeneration(boolean[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] nextGen = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(grid, i, j);
                
                if (grid[i][j]) {
                    // Cell is alive
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        nextGen[i][j] = true;
                    }
                } else {
                    // Cell is dead
                    if (liveNeighbors == 3) {
                        nextGen[i][j] = true;
                    }
                }
            }
        }
        
        return nextGen;
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
                
                int newRow = row + i;
                int newCol = col + j;
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (grid[newRow][newCol]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
