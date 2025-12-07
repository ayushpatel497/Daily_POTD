class Q341_GFG {
    int mod = 1000000007;

    int distinctSubseq(String str) {
        int n = str.length();
        long[] dp = new long[n + 1];
        int[] last = new int[26];

        // initialize last occurrences as -1
        for (int i = 0; i < 26; i++) last[i] = -1;

        dp[0] = 1;  // empty subsequence

        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;

            int ch = str.charAt(i - 1) - 'a';

            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch]] + mod) % mod;
            }

            last[ch] = i - 1;
        }

        return (int) dp[n];
    }
}
