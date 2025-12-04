class Q338_GFG {
    public int minCost(int keys[], int freq[]) {
        int n = keys.length;

        int[][] dp = new int[n][n];
        int[][] opt = new int[n][n];

        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) pre[i+1] = pre[i] + freq[i];

        // prefix sum helper
        java.util.function.BiFunction<Integer, Integer, Integer> sum = 
            (l, r) -> pre[r + 1] - pre[l];

        // initialize for single keys
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
            opt[i][i] = i;
        }

        // length >= 2
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                int leftOpt = opt[i][j - 1];
                int rightOpt = opt[i + 1][j];

                for (int k = leftOpt; k <= rightOpt; k++) {
                    int left = (k > i) ? dp[i][k - 1] : 0;
                    int right = (k < j) ? dp[k + 1][j] : 0;
                    int val = left + right + sum.apply(i, j);

                    if (val < dp[i][j]) {
                        dp[i][j] = val;
                        opt[i][j] = k;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
