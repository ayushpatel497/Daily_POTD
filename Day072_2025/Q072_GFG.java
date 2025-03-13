class Q072_GFG {
    // Function to return max value that can be put in knapsack of capacity W.
    public static int knapSack(int W, int val[], int wt[]) {
        int n = wt.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }

        return dp[W];
    }
}
