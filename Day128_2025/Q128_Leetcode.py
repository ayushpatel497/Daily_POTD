import heapq

class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        inf = float('inf')
        dist = [[inf] * m for _ in range(n)]
        visited = [[False] * m for _ in range(n)]
        dist[0][0] = 0

        pq = [(0, 0, 0)]  # (dis, x, y)

        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        while pq:
            dis, x, y = heapq.heappop(pq)
            if visited[x][y]:
                continue
            if x == n - 1 and y == m - 1:
                break
            visited[x][y] = True

            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    new_dist = max(dist[x][y], moveTime[nx][ny]) + (x + y) % 2 + 1
                    if dist[nx][ny] > new_dist:
                        dist[nx][ny] = new_dist
                        heapq.heappush(pq, (new_dist, nx, ny))

        return dist[n - 1][m - 1]
