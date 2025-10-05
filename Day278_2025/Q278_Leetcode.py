from typing import List

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        n, m = len(heights), len(heights[0])

        pac = [[False] * m for _ in range(n)]
        atl = [[False] * m for _ in range(n)]

        directions = [(1,0), (-1,0), (0,1), (0,-1)]

        def dfs(r, c, vis, prev_height):
            if (r < 0 or r >= n or c < 0 or c >= m or
                vis[r][c] or heights[r][c] < prev_height):
                return
            vis[r][c] = True
            for dr, dc in directions:
                dfs(r + dr, c + dc, vis, heights[r][c])

        # Pacific (top row + left col)
        for i in range(n):
            dfs(i, 0, pac, -1)
            dfs(i, m - 1, atl, -1)
        for j in range(m):
            dfs(0, j, pac, -1)
            dfs(n - 1, j, atl, -1)

        ans = []
        for i in range(n):
            for j in range(m):
                if pac[i][j] and atl[i][j]:
                    ans.append([i, j])
        return ans
