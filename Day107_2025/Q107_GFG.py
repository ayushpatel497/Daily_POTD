import heapq

class Solution:
    def findMinCycle(self, V, edges):
        from collections import defaultdict

        res = float('inf')
        adj = defaultdict(list)
        
        for u, v, w in edges:
            adj[u].append((v, w))

        for u, v, w in edges:
            dist = [float('inf')] * V
            dist[u] = 0
            heap = [(0, u)]

            while heap:
                d, node = heapq.heappop(heap)

                for nei, wt in adj[node]:
                    if (node == u and nei == v) or (node == v and nei == u):
                        continue
                    if dist[node] + wt < dist[nei]:
                        dist[nei] = dist[node] + wt
                        heapq.heappush(heap, (dist[nei], nei))

            if dist[v] != float('inf'):
                res = min(res, dist[v] + w)

        return -1 if res == float('inf') else res
