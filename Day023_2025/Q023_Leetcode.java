import java.util.*;

class Q023_Leetcode {
    public int countServers(int[][] grid) {
        int communicableServers = 0;
        int[] rowCounts = new int[grid[0].length];
        int[] lastServerInRow = new int[grid.length];
        Arrays.fill(lastServerInRow, -1);

        for (int row = 0; row < grid.length; ++row) {
            int serverCountInRow = 0;
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] == 1) {
                    serverCountInRow++;
                    rowCounts[col]++;
                    lastServerInRow[row] = col;
                }
            }
            if (serverCountInRow != 1) {
                communicableServers += serverCountInRow;
                lastServerInRow[row] = -1;
            }
        }

        for (int row = 0; row < grid.length; ++row) {
            if (lastServerInRow[row] != -1 && rowCounts[lastServerInRow[row]] > 1) {
                communicableServers++;
            }
        }
        return communicableServers;
    }
}
