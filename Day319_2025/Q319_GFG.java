class Q319_GFG {
    public int minCutCost(int n, int[] cuts) {

        Arrays.sort(cuts);

        int m = cuts.length;
        int[] arr = new int[m + 2];

        arr[0] = 0;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        arr[m + 1] = n;

        int[][] dp = new int[m + 2][m + 2];

        for (int l = m; l >= 1; l--) {
            for (int r = 1; r <= m; r++) {

                if (l > r) {
                    dp[l][r] = 0;
                    continue;
                }

                int ans = Integer.MAX_VALUE;

                for (int i = l; i <= r; i++) {

                    int cost = arr[r + 1] - arr[l - 1];

                    int left = (l > i - 1) ? 0 : dp[l][i - 1];
                    int right = (i + 1 > r) ? 0 : dp[i + 1][r];

                    ans = Math.min(ans, cost + left + right);
                }

                dp[l][r] = ans;
            }
        }

        return dp[1][m];
    }
}
