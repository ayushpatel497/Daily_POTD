import java.util.*;

class Q018_Leetcode {
    public int minCost(int[][] grid) {
        // Q. Minimum Cost to Make at Least One Valid Path in a Grid
        int rowSize = grid.length;
        int colSize = grid[0].length;

        int[][] minimumCost = new int[rowSize][colSize];
        for (int[] row : minimumCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> positionDeque = new LinkedList<>();
        positionDeque.addFirst(new int[]{0, 0});
        minimumCost[0][0] = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!positionDeque.isEmpty()) {
            int[] current = positionDeque.pollFirst();
            int row = current[0], col = current[1];

            for (int direction = 0; direction < 4; ++direction) {
                int newRow = row + directions[direction][0];
                int newCol = col + directions[direction][1];
                int cost = (grid[row][col] != direction + 1) ? 1 : 0;

                if (isValid(newRow, newCol, rowSize, colSize) && (minimumCost[row][col] + cost < minimumCost[newRow][newCol])) {
                    minimumCost[newRow][newCol] = minimumCost[row][col] + cost;

                    if (cost == 1) {
                        positionDeque.addLast(new int[]{newRow, newCol});
                    } else {
                        positionDeque.addFirst(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return minimumCost[rowSize - 1][colSize - 1];
    }

    private boolean isValid(int newRow, int newCol, int rowSize, int colSize) {
        return newRow >= 0 && newCol >= 0 && newRow < rowSize && newCol < colSize;
    }
}
