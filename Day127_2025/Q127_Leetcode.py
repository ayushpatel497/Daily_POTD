import heapq
from typing import List

class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        inf = float('inf')
        d = [[inf] * m for _ in range(n)]
        visited = [[False] * m for _ in range(n)]
        d[0][0] = 0
        heap = [(0, 0, 0)]  # (dis, x, y)
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        while heap:
            dis, x, y = heapq.heappop(heap)
            if visited[x][y]:
                continue
            visited[x][y] = True

            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    nd = max(d[x][y], moveTime[nx][ny]) + 1
                    if d[nx][ny] > nd:
                        d[nx][ny] = nd
                        heapq.heappush(heap, (nd, nx, ny))

        return d[n-1][m-1]
