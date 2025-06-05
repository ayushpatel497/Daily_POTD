from collections import deque, defaultdict

class Solution:
    def countPaths(self, edges, V, src, dest):
        adj = [[] for _ in range(V)]
        inDeg = [0] * V

        for u, v in edges:
            adj[u].append(v)
            inDeg[v] += 1

        q = deque(i for i in range(V) if inDeg[i] == 0)
        paths = [0] * V
        paths[src] = 1

        while q:
            u = q.popleft()
            for v in adj[u]:
                paths[v] += paths[u]
                inDeg[v] -= 1
                if inDeg[v] == 0:
                    q.append(v)

        return paths[dest]
