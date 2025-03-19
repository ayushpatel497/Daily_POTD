class Q078_GFG {
    public int maxProfit(int[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int t = 0; t <= k; t++) {
                if (i == 0) {
                    // Base case: first day
                    dp[i][t][1] = -prices[i]; // Buying
                    dp[i][t][0] = 0;         // Not holding any stock
                } else if (t == 0) {
                    // No transactions allowed
                    dp[i][t][1] = Math.max(dp[i - 1][t][1], -prices[i]);
                    dp[i][t][0] = 0;
                } else {
                    // Recurrence relation
                    dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t - 1][0] - prices[i]);
                    dp[i][t][0] = Math.max(dp[i - 1][t][0], dp[i - 1][t][1] + prices[i]);
                }
            }
        }

        return dp[n - 1][k][0]; // Maximum profit with at most k transactions
    }
}