import java.util.PriorityQueue;

class Q019_Leetcode {
    private static class Cell implements Comparable<Cell> {
        int height, row, col;

        Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int rowSize = heightMap.length;
        int colSize = heightMap[0].length;

        boolean[][] visited = new boolean[rowSize][colSize];
        PriorityQueue<Cell> boundary = new PriorityQueue<>();

        // Add boundary cells to the priority queue
        for (int row = 0; row < rowSize; ++row) {
            boundary.offer(new Cell(heightMap[row][0], row, 0));
            boundary.offer(new Cell(heightMap[row][colSize - 1], row, colSize - 1));
            visited[row][0] = true;
            visited[row][colSize - 1] = true;
        }
        for (int col = 0; col < colSize; ++col) {
            boundary.offer(new Cell(heightMap[0][col], 0, col));
            boundary.offer(new Cell(heightMap[rowSize - 1][col], rowSize - 1, col));
            visited[0][col] = true;
            visited[rowSize - 1][col] = true;
        }

        int totalWaterVolume = 0;
        int[] directionRow = {0, 0, -1, 1};
        int[] directionCol = {-1, 1, 0, 0};

        // Process cells in the priority queue
        while (!boundary.isEmpty()) {
            Cell currentCell = boundary.poll();
            int minBoundaryHeight = currentCell.height;

            for (int direction = 0; direction < 4; ++direction) {
                int neighborRow = currentCell.row + directionRow[direction];
                int neighborCol = currentCell.col + directionCol[direction];

                if (isValidCell(neighborRow, neighborCol, rowSize, colSize) && !visited[neighborRow][neighborCol]) {
                    int neighborHeight = heightMap[neighborRow][neighborCol];

                    if (neighborHeight < minBoundaryHeight) {
                        totalWaterVolume += minBoundaryHeight - neighborHeight;
                    }

                    boundary.offer(new Cell(Math.max(neighborHeight, minBoundaryHeight), neighborRow, neighborCol));
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }
        return totalWaterVolume;
    }

    private boolean isValidCell(int row, int col, int rowSize, int colSize) {
        return row >= 0 && col >= 0 && row < rowSize && col < colSize;
    }
}
