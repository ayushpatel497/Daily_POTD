class Solution:
    def diameter(self, V, edges):
        from collections import defaultdict

        def dfs(node, dist, adj, visited):
            nonlocal max_dist, farthest_node
            visited[node] = True
            if dist > max_dist:
                max_dist = dist
                farthest_node = node
            for nei in adj[node]:
                if not visited[nei]:
                    dfs(nei, dist + 1, adj, visited)

        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visited = [False] * V
        max_dist, farthest_node = 0, 0
        dfs(0, 0, adj, visited)

        visited = [False] * V
        max_dist = 0
        dfs(farthest_node, 0, adj, visited)

        return max_dist
