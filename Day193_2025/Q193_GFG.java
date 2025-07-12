class Q193_GFG {
    int n, m;

    public int maxGold(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        int res = 0;
        int[][] dp = new int[n][m];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int i = 0; i < n; i++) {
            res = Math.max(res, collectGold(mat, dp, i, 0));
        }

        return res;
    }

    private int collectGold(int[][] grid, int[][] dp, int i, int j) {
        if (i < 0 || i >= n || j >= m) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int right = collectGold(grid, dp, i, j + 1);
        int rightUp = collectGold(grid, dp, i - 1, j + 1);
        int rightDown = collectGold(grid, dp, i + 1, j + 1);

        return dp[i][j] = grid[i][j] + Math.max(right, Math.max(rightUp, rightDown));
    }
}
