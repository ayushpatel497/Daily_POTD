class Solution:
    def topoSort(self, V, edges):
        from collections import deque, defaultdict
        
        adj = defaultdict(list)
        inDegree = [0] * V
        
        for u, v in edges:
            adj[u].append(v)
            inDegree[v] += 1

        q = deque([i for i in range(V) if inDegree[i] == 0])
        result = []

        while q:
            node = q.popleft()
            result.append(node)
            for neighbor in adj[node]:
                inDegree[neighbor] -= 1
                if inDegree[neighbor] == 0:
                    q.append(neighbor)

        return result
