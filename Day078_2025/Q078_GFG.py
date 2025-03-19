from typing import List

class Solution:
    def maxProfit(self, prices: List[int], k: int) -> int:
        n = len(prices)
        if n == 0 or k == 0:
            return 0

        dp = [[[0] * 2 for _ in range(k + 1)] for _ in range(n)]

        for i in range(n):
            for t in range(k + 1):
                if i == 0:
                    # Base case: first day
                    dp[i][t][1] = -prices[i]  # Buying
                    dp[i][t][0] = 0  # Not holding any stock
                elif t == 0:
                    # No transactions allowed
                    dp[i][t][1] = max(dp[i - 1][t][1], -prices[i])
                    dp[i][t][0] = 0
                else:
                    # Recurrence relation
                    dp[i][t][1] = max(dp[i - 1][t][1], dp[i - 1][t - 1][0] - prices[i])
                    dp[i][t][0] = max(dp[i - 1][t][0], dp[i - 1][t][1] + prices[i])

        return dp[n - 1][k][0]  # Maximum profit with at most k transactions
