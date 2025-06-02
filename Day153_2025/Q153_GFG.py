class Solution:
    def uniquePaths(self, grid):
        n, m = len(grid), len(grid[0])

        if grid[0][0] == 1 or grid[n - 1][m - 1] == 1:
            return 0

        dp = [0] * m
        dp[m - 1] = 1

        # Fill bottom row
        for j in range(m - 2, -1, -1):
            dp[j] = 0 if grid[n - 1][j] == 1 else dp[j + 1]

        # Traverse remaining rows
        for i in range(n - 2, -1, -1):
            if grid[i][m - 1] == 1:
                dp[m - 1] = 0
            for j in range(m - 2, -1, -1):
                if grid[i][j] == 1:
                    dp[j] = 0
                else:
                    dp[j] = dp[j] + dp[j + 1]

        return dp[0]
