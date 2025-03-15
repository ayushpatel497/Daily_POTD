import java.util.Arrays;

class Q074_GFG {
    public int minCoins(int[] coins, int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 coins needed to make sum 0

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}
