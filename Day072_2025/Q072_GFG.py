class Solution:
    # Function to return max value that can be put in knapsack of capacity W.
    def knapsack(self, W, val, wt):
        n = len(wt)
        dp = [0] * (W + 1)

        for i in range(n):
            for j in range(W, wt[i] - 1, -1):
                dp[j] = max(dp[j], dp[j - wt[i]] + val[i])

        return dp[W]
