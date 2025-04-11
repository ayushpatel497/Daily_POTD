import heapq

class Solution:
    def dijkstra(self, V, edges, src):
        from collections import defaultdict

        adj = defaultdict(list)
        for u, v, w in edges:
            adj[u].append((w, v))
            adj[v].append((w, u))

        dist = [float('inf')] * V
        dist[src] = 0
        pq = [(0, src)]

        while pq:
            d, u = heapq.heappop(pq)
            for w, v in adj[u]:
                if dist[v] > d + w:
                    dist[v] = d + w
                    heapq.heappush(pq, (dist[v], v))

        return dist
