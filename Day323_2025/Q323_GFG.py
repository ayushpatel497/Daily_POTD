import heapq

class Solution:
    def minCostPath(self, heights):
        n = len(heights)
        m = len(heights[0])

        dist = [[10**9] * m for _ in range(n)]
        dist[0][0] = 0

        pq = [(0, 0, 0)]  # (effort, r, c)

        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]

        while pq:
            effort, r, c = heapq.heappop(pq)

            if r == n - 1 and c == m - 1:
                return effort

            for i in range(4):
                nr = r + dx[i]
                nc = c + dy[i]

                if 0 <= nr < n and 0 <= nc < m:
                    new_effort = max(
                        abs(heights[r][c] - heights[nr][nc]),
                        effort
                    )

                    if dist[nr][nc] > new_effort:
                        dist[nr][nc] = new_effort
                        heapq.heappush(pq, (new_effort, nr, nc))
