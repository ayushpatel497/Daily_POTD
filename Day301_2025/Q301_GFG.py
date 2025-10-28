from collections import deque

class Solution:
    def nearest(self, grid):
        row, col = len(grid), len(grid[0])
        ans = [[-1] * col for _ in range(row)]
        q = deque()

        # Add all cells containing 1 to queue
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1:
                    q.append((i, j))
                    ans[i][j] = 0

        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        while q:
            a, b = q.popleft()
            for dx, dy in directions:
                na, nb = a + dx, b + dy
                if 0 <= na < row and 0 <= nb < col and ans[na][nb] == -1:
                    ans[na][nb] = ans[a][b] + 1
                    q.append((na, nb))

        return ans
