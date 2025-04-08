class Solution:
    def dfs(self, node, adj, c, d, visited):
        visited[node] = True
        for neighbor in adj[node]:
            if not visited[neighbor] and not ((node == c and neighbor == d) or (node == d and neighbor == c)):
                self.dfs(neighbor, adj, c, d, visited)

    def isBridge(self, V, edges, c, d):
        adj = [[] for _ in range(V)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visited = [False] * V
        self.dfs(c, adj, c, d, visited)
        return not visited[d]
