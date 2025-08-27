from typing import List


class Solution:
    def lenOfVDiagonal(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [(1,1),(1,-1),(-1,-1),(-1,1)]
        memo = {}

        def dfs(cx, cy, direction, turn, target):
            nx, ny = cx + dirs[direction][0], cy + dirs[direction][1]
            if nx < 0 or ny < 0 or nx >= m or ny >= n or grid[nx][ny] != target:
                return 0
            if (nx, ny, direction, turn) in memo:
                return memo[(nx, ny, direction, turn)]

            maxStep = dfs(nx, ny, direction, turn, 2 - target)
            if turn:
                maxStep = max(maxStep, dfs(nx, ny, (direction + 1) % 4, False, 2 - target))

            memo[(nx, ny, direction, turn)] = maxStep + 1
            return maxStep + 1

        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    for d in range(4):
                        res = max(res, dfs(i, j, d, True, 2) + 1)
        return res
