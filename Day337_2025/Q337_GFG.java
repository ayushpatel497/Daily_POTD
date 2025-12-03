class Q337_GFG {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int N = 1 << n;

        int[][] dp = new int[N][n];
        int INF = (int)1e9;

        // Initialize dp with INF
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = INF;
            }
        }

        dp[1][0] = 0;  // Starting at city 0

        for (int mask = 0; mask < N; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;

                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;

                    int nextMask = mask | (1 << v);

                    dp[nextMask][v] = Math.min(dp[nextMask][v],
                                               dp[mask][u] + cost[u][v]);
                }
            }
        }

        int ans = INF;
        int fullMask = (1 << n) - 1;

        for (int u = 0; u < n; u++) {
            ans = Math.min(ans, dp[fullMask][u] + cost[u][0]);
        }

        return ans;
    }
}
