import heapq

class Solution:
    def countPaths(self, V, edges):
        MOD = 10**9 + 7
        
        adj = [[] for _ in range(V)]
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))
        
        dist = [float('inf')] * V
        ways = [0] * V
        dist[0] = 0
        ways[0] = 1
        
        pq = [(0, 0)]  # (distance, node)
        
        while pq:
            currDist, node = heapq.heappop(pq)
            
            for adjNode, wt in adj[node]:
                if currDist + wt < dist[adjNode]:
                    dist[adjNode] = currDist + wt
                    ways[adjNode] = ways[node]
                    heapq.heappush(pq, (dist[adjNode], adjNode))
                
                elif currDist + wt == dist[adjNode]:
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD
        
        return ways[V - 1]
