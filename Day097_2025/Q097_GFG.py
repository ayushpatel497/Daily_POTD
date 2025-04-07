class Solution:
    def isCycle(self, V, edges):
        adj = [[] for _ in range(V)]
        for u, v in edges:
            adj[u].append(v)

        visited = [False] * V
        recStack = [False] * V

        def dfs(node):
            visited[node] = True
            recStack[node] = True

            for neighbor in adj[node]:
                if not visited[neighbor]:
                    if dfs(neighbor):
                        return True
                elif recStack[neighbor]:
                    return True

            recStack[node] = False
            return False

        for i in range(V):
            if not visited[i]:
                if dfs(i):
                    return True

        return False
