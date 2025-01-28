class Q028_Leetcode {
    private final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean isValid(int row, int col, int rowSize, int colSize) {
        return row >= 0 && col >= 0 && row < rowSize && col < colSize;
    }

    private int getMaxFishes(int row, int col, int rowSize, int colSize, int[][] grid) {
        int currentFishes = grid[row][col];
        grid[row][col] = 0; // Mark as visited

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(newRow, newCol, rowSize, colSize) && grid[newRow][newCol] != 0) {
                currentFishes += getMaxFishes(newRow, newCol, rowSize, colSize, grid);
            }
        }

        return currentFishes;
    }

    public int findMaxFish(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int maxFishes = 0;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] != 0) {
                    int currentFishes = getMaxFishes(row, col, rowSize, colSize, grid);
                    maxFishes = Math.max(maxFishes, currentFishes);
                }
            }
        }

        return maxFishes;
    }
}
