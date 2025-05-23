class Solution:
    def noOfWays(self, m, n, x):
        curr = [0] * (x + 1)
        next_dp = [0] * (x + 1)
        next_dp[0] = 1

        for i in range(n - 1, -1, -1):
            curr = [0] * (x + 1)
            for s in range(1, x + 1):
                curr[s] = curr[s - 1] + next_dp[s - 1]
                if s - 1 - m >= 0:
                    curr[s] -= next_dp[s - 1 - m]
            next_dp = curr

        return next_dp[x]
