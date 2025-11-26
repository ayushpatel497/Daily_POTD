from typing import List


class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])

        dp = [[[0] * k for _ in range(n + 1)] for _ in range(m + 1)]

        for i in range(1, m + 1):
            for j in range(1, n + 1):

                if i == 1 and j == 1:
                    dp[1][1][grid[0][0] % k] = 1
                    continue

                value = grid[i - 1][j - 1] % k

                for r in range(k):
                    prevMod = (r - value + k) % k
                    dp[i][j][r] = (dp[i - 1][j][prevMod] + dp[i][j - 1][prevMod]) % MOD

        return dp[m][n][0]
