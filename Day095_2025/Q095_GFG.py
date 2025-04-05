class Solution:
    def numIslands(self, grid):
        from collections import deque
        
        if not grid:
            return 0
        
        m, n = len(grid), len(grid[0])
        directions = [(1,0), (0,1), (-1,0), (0,-1), (0,0), (-1,-1), (1,1), (-1,1), (1,-1)]
        visited = [[False]*n for _ in range(m)]

        def bfs(i, j):
            q = deque()
            q.append((i, j))
            visited[i][j] = True
            while q:
                x, y = q.popleft()
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == 'L' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        q.append((nx, ny))
        
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 'L' and not visited[i][j]:
                    bfs(i, j)
                    count += 1
        return count
