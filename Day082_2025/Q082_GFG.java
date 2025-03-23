class Q082_GFG {
    private static final int MOD = 1_000_000_007;

    public int countWays(String digits) {
        int n = digits.length();
        if (digits.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1; 
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            char single = digits.charAt(i - 1);
            char doubleFirst = digits.charAt(i - 2);

            if (single >= '1') {
                dp[i] = dp[i - 1] % MOD;
            }
            if (doubleFirst == '1' || (doubleFirst == '2' && single <= '6')) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        return dp[n];
    }
}
