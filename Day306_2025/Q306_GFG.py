from typing import List


class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        grid = [[0] * n for _ in range(m)]  # 0 = empty, 1 = guarded, 2 = guard/wall

        for x, y in guards:
            grid[x][y] = 2
        for x, y in walls:
            grid[x][y] = 2

        dirs = [-1, 0, 1, 0, -1]

        for gx, gy in guards:
            for k in range(4):
                x, y = gx, gy
                dx, dy = dirs[k], dirs[k + 1]
                while 0 <= x + dx < m and 0 <= y + dy < n and grid[x + dx][y + dy] < 2:
                    x += dx
                    y += dy
                    grid[x][y] = 1

        # Count unguarded cells
        return sum(row.count(0) for row in grid)
