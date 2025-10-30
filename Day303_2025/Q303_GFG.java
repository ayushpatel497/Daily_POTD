import java.util.*;

class Q303_GFG {
    public void fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Add border 'O's to queue
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') q.add(new int[]{i, 0});
            if (grid[i][m - 1] == 'O') q.add(new int[]{i, m - 1});
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O') q.add(new int[]{0, j});
            if (grid[n - 1][j] == 'O') q.add(new int[]{n - 1, j});
        }

        // BFS to mark connected 'O's as '#'
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] != 'O') continue;
            grid[x][y] = '#';
            for (int[] d : dirs) {
                q.add(new int[]{x + d[0], y + d[1]});
            }
        }

        // Convert remaining 'O' to 'X' and '#' back to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') grid[i][j] = 'X';
                else if (grid[i][j] == '#') grid[i][j] = 'O';
            }
        }
    }
}
