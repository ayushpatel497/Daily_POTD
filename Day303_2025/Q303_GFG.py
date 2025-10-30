from collections import deque

class Solution:
    def fill(self, grid):
        n, m = len(grid), len(grid[0])
        q = deque()

        # Add border 'O's to queue
        for i in range(n):
            if grid[i][0] == 'O': q.append((i, 0))
            if grid[i][m - 1] == 'O': q.append((i, m - 1))
        for j in range(m):
            if grid[0][j] == 'O': q.append((0, j))
            if grid[n - 1][j] == 'O': q.append((n - 1, j))

        # BFS to mark connected 'O's as '#'
        while q:
            x, y = q.popleft()
            if x < 0 or y < 0 or x >= n or y >= m or grid[x][y] != 'O':
                continue
            grid[x][y] = '#'
            q.extend([(x+1, y), (x-1, y), (x, y+1), (x, y-1)])

        # Convert remaining 'O' to 'X' and '#' back to 'O'
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 'O':
                    grid[i][j] = 'X'
                elif grid[i][j] == '#':
                    grid[i][j] = 'O'
