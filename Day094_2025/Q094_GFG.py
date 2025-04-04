from typing import List

class Solution:
    def dfs(self, node: int, parent: int, adj: List[List[int]], visited: List[bool]) -> bool:
        visited[node] = True

        for neighbor in adj[node]:
            if neighbor != parent:  # Ignore edge to parent
                if visited[neighbor]:
                    return True  # Cycle detected
                if self.dfs(neighbor, node, adj, visited):
                    return True
        return False

    def isCycle(self, V: int, edges: List[List[int]]) -> bool:
        # Create adjacency list
        adj = [[] for _ in range(V)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        # DFS for cycle detection
        visited = [False] * V
        for i in range(V):
            if not visited[i] and self.dfs(i, -1, adj, visited):
                return True
        return False
