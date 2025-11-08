class Solution:
    def numberOfPath(self, mat, k):
        from functools import lru_cache
        n, m = len(mat), len(mat[0])

        @lru_cache(None)
        def dfs(i, j, cnt):
            if i >= n or j >= m:
                return 0
            if i == n - 1 and j == m - 1:
                return 1 if mat[i][j] == k - cnt else 0

            newCnt = cnt + mat[i][j]
            return dfs(i + 1, j, newCnt) + dfs(i, j + 1, newCnt)

        return dfs(0, 0, 0)
