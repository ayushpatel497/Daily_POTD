class Solution:
    def maxGold(self, mat):
        n, m = len(mat), len(mat[0])
        dp = [[-1 for _ in range(m)] for _ in range(n)]

        def f(i, j):
            if i < 0 or i >= n or j >= m:
                return 0
            if dp[i][j] != -1:
                return dp[i][j]
            right = f(i, j + 1)
            right_up = f(i - 1, j + 1)
            right_down = f(i + 1, j + 1)
            dp[i][j] = mat[i][j] + max(right, right_up, right_down)
            return dp[i][j]

        res = 0
        for i in range(n):
            res = max(res, f(i, 0))
        return res
