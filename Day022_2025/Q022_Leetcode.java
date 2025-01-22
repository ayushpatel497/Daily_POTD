import java.util.*;

class Q022_Leetcode {
    public int[][] highestPeak(int[][] isWater) {
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        int rowSize = isWater.length;
        int colSize = isWater[0].length;
        int[][] cellHeights = new int[rowSize][colSize];
        Queue<int[]> cellQueue = new LinkedList<>();

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (isWater[i][j] == 1) {
                    cellQueue.offer(new int[]{i, j});
                    cellHeights[i][j] = 0;
                } else {
                    cellHeights[i][j] = -1;
                }
            }
        }

        int heightOfNextLayer = 1;
        while (!cellQueue.isEmpty()) {
            int layerSize = cellQueue.size();
            for (int size = 0; size < layerSize; size++) {
                int[] currentCell = cellQueue.poll();
                for (int direction = 0; direction < 4; direction++) {
                    int neighborX = currentCell[0] + directionX[direction];
                    int neighborY = currentCell[1] + directionY[direction];
                    if (isValidCell(neighborX, neighborY, rowSize, colSize) && cellHeights[neighborX][neighborY] == -1) {
                        cellHeights[neighborX][neighborY] = heightOfNextLayer;
                        cellQueue.offer(new int[]{neighborX, neighborY});
                    }
                }
            }
            heightOfNextLayer++;
        }

        return cellHeights;
    }

    private boolean isValidCell(int x, int y, int rowSize, int colSize) {
        return x >= 0 && y >= 0 && x < rowSize && y < colSize;
    }
}
