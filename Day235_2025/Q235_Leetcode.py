from typing import List

class Solution:
    def minimumSum(self, grid: List[List[int]]) -> int:
        def minimum_sum(grid, u, d, l, r):
            n, m = len(grid), len(grid[0])
            min_i, max_i = n, 0
            min_j, max_j = m, 0
            for i in range(u, d + 1):
                for j in range(l, r + 1):
                    if grid[i][j] == 1:
                        min_i = min(min_i, i)
                        min_j = min(min_j, j)
                        max_i = max(max_i, i)
                        max_j = max(max_j, j)
            return (max_i - min_i + 1) * (max_j - min_j + 1) if min_i <= max_i else float("inf")

        def rotate(vec):
            n, m = len(vec), len(vec[0])
            ret = [[0] * n for _ in range(m)]
            for i in range(n):
                for j in range(m):
                    ret[m - j - 1][i] = vec[i][j]
            return ret

        def solve(grid):
            n, m = len(grid), len(grid[0])
            res = n * m
            for i in range(n - 1):
                for j in range(m - 1):
                    res = min(res, minimum_sum(grid, 0, i, 0, m - 1) +
                                   minimum_sum(grid, i + 1, n - 1, 0, j) +
                                   minimum_sum(grid, i + 1, n - 1, j + 1, m - 1))
                    res = min(res, minimum_sum(grid, 0, i, 0, j) +
                                   minimum_sum(grid, 0, i, j + 1, m - 1) +
                                   minimum_sum(grid, i + 1, n - 1, 0, m - 1))
            for i in range(n - 2):
                for j in range(i + 1, n - 1):
                    res = min(res, minimum_sum(grid, 0, i, 0, m - 1) +
                                   minimum_sum(grid, i + 1, j, 0, m - 1) +
                                   minimum_sum(grid, j + 1, n - 1, 0, m - 1))
            return res

        rgrid = rotate(grid)
        return min(solve(grid), solve(rgrid))
