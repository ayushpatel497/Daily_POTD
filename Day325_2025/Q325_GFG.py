import heapq

class Solution:

    def dijkstra(self, start, V, adj):
        INF = 10**9
        dist = [INF] * (V + 1)
        dist[start] = 0

        pq = [(0, start)]  # (distance, node)

        while pq:
            d, node = heapq.heappop(pq)

            for v, wt in adj[node]:
                if dist[v] > d + wt:
                    dist[v] = d + wt
                    heapq.heappush(pq, (dist[v], v))

        return dist

    def shortestPath(self, V, a, b, edges):
        adj = [[] for _ in range(V + 1)]
        curved = []

        for u, v, wt, cwt in edges:
            adj[u].append((v, wt))
            adj[v].append((u, wt))
            curved.append((u, v, cwt))

        dist1 = self.dijkstra(a, V, adj)
        dist2 = self.dijkstra(b, V, adj)

        ans = dist1[b]
        INF = 10**9

        for u, v, cwt in curved:
            ans = min(ans, dist1[u] + cwt + dist2[v])
            ans = min(ans, dist1[v] + cwt + dist2[u])

        return -1 if ans >= INF else ans
