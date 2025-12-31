from collections import deque
from typing import List

class Solution:
    def isPossible(self, m, n, t, cells):
        grid = [[0] * (n + 1) for _ in range(m + 1)]
        dirs = [(1,0), (-1,0), (0,1), (0,-1)]

        # flood cells till day t
        for i in range(t):
            r, c = cells[i]
            grid[r][c] = 1

        q = deque()

        # start from top row
        for j in range(1, n + 1):
            if grid[1][j] == 0:
                q.append((1, j))
                grid[1][j] = 1

        while q:
            r, c = q.popleft()
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 < nr <= m and 0 < nc <= n and grid[nr][nc] == 0:
                    if nr == m:
                        return True
                    grid[nr][nc] = 1
                    q.append((nr, nc))
        return False

    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        left, right = 0, row * col
        ans = 0

        while left < right - 1:
            mid = left + (right - left) // 2
            if self.isPossible(row, col, mid, cells):
                ans = mid
                left = mid
            else:
                right = mid
        return ans
