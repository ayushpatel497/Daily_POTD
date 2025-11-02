class Q306_GFG {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];  // 0 = empty, 1 = guarded, 2 = guard/wall

        // Mark guards and walls
        for (int[] g : guards) grid[g[0]][g[1]] = 2;
        for (int[] w : walls) grid[w[0]][w[1]] = 2;

        int[] dirs = {-1, 0, 1, 0, -1};

        // Mark guarded cells
        for (int[] guard : guards) {
            for (int k = 0; k < 4; k++) {
                int x = guard[0];
                int y = guard[1];
                int dx = dirs[k], dy = dirs[k + 1];
                while (x + dx >= 0 && x + dx < m && y + dy >= 0 && y + dy < n && grid[x + dx][y + dy] < 2) {
                    x += dx;
                    y += dy;
                    grid[x][y] = 1;
                }
            }
        }

        // Count unguarded cells (0)
        int unguarded = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0)
                    unguarded++;

        return unguarded;
    }
}
