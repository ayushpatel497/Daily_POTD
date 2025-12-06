class Solution:
    def solve(self, i, j, arr, dp):
        if i > j:
            return 0
        if dp[i][j] != -1:
            return dp[i][j]

        takeL = arr[i] + min(
            self.solve(i+2, j, arr, dp),
            self.solve(i+1, j-1, arr, dp)
        )

        takeR = arr[j] + min(
            self.solve(i+1, j-1, arr, dp),
            self.solve(i, j-2, arr, dp)
        )

        dp[i][j] = max(takeL, takeR)
        return dp[i][j]

    def maximumAmount(self, arr):
        n = len(arr)
        dp = [[-1]*n for _ in range(n)]
        return self.solve(0, n-1, arr, dp)
