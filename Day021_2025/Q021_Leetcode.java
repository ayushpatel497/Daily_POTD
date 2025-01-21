class Q021_Leetcode {
    public long gridGame(int[][] grid) {
        // Calculate the sum of the first row
        long firstRowSum = 0;
        for (int num : grid[0]) {
            firstRowSum += num;
        }

        long secondRowSum = 0;
        long minimumSum = Long.MAX_VALUE;

        // Iterate over each column to determine the minimum sum
        for (int turnIndex = 0; turnIndex < grid[0].length; turnIndex++) {
            firstRowSum -= grid[0][turnIndex]; // Remove the current column from the first row sum
            minimumSum = Math.min(minimumSum, Math.max(firstRowSum, secondRowSum));
            secondRowSum += grid[1][turnIndex]; // Add the current column to the second row sum
        }

        return minimumSum;
    }
}
