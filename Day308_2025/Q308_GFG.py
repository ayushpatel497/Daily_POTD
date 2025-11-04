class Solution:
    def minCost(self, height):
        n = len(height)
        if n == 1:
            return 0

        dp = [0] * n
        dp[0] = 0
        dp[1] = abs(height[1] - height[0])

        for i in range(2, n):
            one_jump = dp[i - 1] + abs(height[i] - height[i - 1])
            two_jump = dp[i - 2] + abs(height[i] - height[i - 2])
            dp[i] = min(one_jump, two_jump)

        return dp[-1]
