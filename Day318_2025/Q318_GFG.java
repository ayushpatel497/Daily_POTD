class Q318_GFG {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;

        // If it's impossible to end with 1 pile
        if ((n - 1) % (k - 1) != 0) return -1;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stones[i];

        // function to get sum in [l, r]
        java.util.function.BiFunction<Integer, Integer, Integer> getSum =
            (l, r) -> prefix[r + 1] - prefix[l];

        final int INF = (int) 1e9;

        int[][][] dp = new int[n][n][k + 1];

        // initialize dp with INF
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int t = 1; t <= k; t++)
                    dp[i][j][t] = INF;

        for (int i = 0; i < n; i++)
            dp[i][i][1] = 0;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                for (int t = 2; t <= k; t++) {
                    dp[i][j][t] = INF;
                    for (int mid = i; mid < j; mid += (k - 1)) {
                        if (dp[i][mid][1] == INF || dp[mid + 1][j][t - 1] == INF)
                            continue;

                        dp[i][j][t] = Math.min(dp[i][j][t],
                                dp[i][mid][1] + dp[mid + 1][j][t - 1]);
                    }
                }

                if (dp[i][j][k] < INF) {
                    dp[i][j][1] = dp[i][j][k] + getSum.apply(i, j);
                }
            }
        }

        return dp[0][n - 1][1];
    }
}
