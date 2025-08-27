class Q239_Leetcode {
    private int m, n;
    private int[][] dirs = {{1,1},{1,-1},{-1,-1},{-1,1}};
    private int[][][][] fullMemo;

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fullMemo = new int[m][n][4][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    for (int t = 0; t < 2; t++) {
                        fullMemo[i][j][d][t] = -1;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        res = Math.max(res, dfs(grid, i, j, d, 1, 2) + 1);
                    }
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int cx, int cy, int direction, int turn, int target) {
        int nx = cx + dirs[direction][0];
        int ny = cy + dirs[direction][1];
        if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != target) {
            return 0;
        }
        if (fullMemo[nx][ny][direction][turn] != -1) {
            return fullMemo[nx][ny][direction][turn];
        }

        int maxStep = dfs(grid, nx, ny, direction, turn, 2 - target);
        if (turn == 1) {
            maxStep = Math.max(maxStep, dfs(grid, nx, ny, (direction + 1) % 4, 0, 2 - target));
        }

        fullMemo[nx][ny][direction][turn] = maxStep + 1;
        return maxStep + 1;
    }
}
