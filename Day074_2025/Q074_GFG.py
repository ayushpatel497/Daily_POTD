class Solution:
    def minCoins(self, coins, sum):
        dp = [float('inf')] * (sum + 1)
        dp[0] = 0  # Base case: 0 coins needed to make sum 0

        for coin in coins:
            for j in range(coin, sum + 1):
                if dp[j - coin] != float('inf'):
                    dp[j] = min(dp[j], dp[j - coin] + 1)

        return dp[sum] if dp[sum] != float('inf') else -1
