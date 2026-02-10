package org.example;

/**
 * Implementation of Conway's Game of Life.
 * <p>
 * This class simulates cellular automaton devised by mathematician John Conway.
 * The game evolves on a two-dimensional grid where each cell is either alive or dead.
 * The next generation is determined by four rules:
 * <ul>
 * <li>Any live cell with fewer than two live neighbours dies (underpopulation)</li>
 * <li>Any live cell with more than three live neighbours dies (overcrowding)</li>
 * <li>Any live cell with two or three live neighbours lives on</li>
 * <li>Any dead cell with exactly three live neighbours becomes alive (reproduction)</li>
 * </ul>
 */
public class GameOfLife {

    /**
     * Calculates the next generation of the grid based on Conway's Game of Life rules.
     * <p>
     * The grid is finite and no life can exist off the edges. Cells outside the grid
     * boundaries are considered permanently dead.
     *
     * @param grid the current generation as a 2D boolean array where true represents
     *             a live cell and false represents a dead cell
     * @return a new 2D boolean array representing the next generation
     */
    public boolean[][] nextGeneration(boolean[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] nextGen = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(grid, i, j);
                
                if (grid[i][j]) {
                    nextGen[i][j] = liveNeighbors == 2 || liveNeighbors == 3;
                } else {
                    nextGen[i][j] = liveNeighbors == 3;
                }
            }
        }
        
        return nextGen;
    }
    
    /**
     * Counts the number of live neighbors for a cell at the given position.
     * <p>
     * Only counts the 8 adjacent cells (horizontal, vertical, and diagonal).
     * Cells outside the grid boundaries are not counted.
     *
     * @param grid the current generation grid
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the count of live neighbors (0-8)
     */
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
                
                if (isValidCell(newRow, newCol, rows, cols) && grid[newRow][newCol]) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Checks if the given cell coordinates are within the grid boundaries.
     *
     * @param row the row index to check
     * @param col the column index to check
     * @param rows the total number of rows in the grid
     * @param cols the total number of columns in the grid
     * @return true if the cell is within bounds, false otherwise
     */
    private boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
