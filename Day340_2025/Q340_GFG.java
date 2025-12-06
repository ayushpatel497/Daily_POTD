class Q340_GFG {
    private int solve(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int takeL = arr[i] + Math.min(
                solve(i + 2, j, arr, dp),
                solve(i + 1, j - 1, arr, dp)
        );

        int takeR = arr[j] + Math.min(
                solve(i + 1, j - 1, arr, dp),
                solve(i, j - 2, arr, dp)
        );

        return dp[i][j] = Math.max(takeL, takeR);
    }

    public int maximumAmount(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return solve(0, n - 1, arr, dp);
    }
}
