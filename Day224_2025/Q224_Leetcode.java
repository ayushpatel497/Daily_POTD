class Q224_Leetcode {
    public int numberOfWays(int n, int x) {
        int mod = (int)1e9 + 7;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            long val = (long)Math.pow(i, x);
            if (val > n) {
                break;
            }
            for (int j = n; j >= val; j--) {
                dp[j] = (dp[j] + dp[(int)(j - val)]) % mod;
            }
        }
        return (int)dp[n];
    }
}
