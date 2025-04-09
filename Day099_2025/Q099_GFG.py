class Solution:
    def articulationPoints(self, V, edges):
        from collections import defaultdict
        self.timer = 0

        def dfs(node, parent):
            vis[node] = True
            tin[node] = low[node] = self.timer
            self.timer += 1
            children = 0

            for nbr in adj[node]:
                if nbr == parent:
                    continue
                if not vis[nbr]:
                    dfs(nbr, node)
                    low[node] = min(low[node], low[nbr])
                    if low[nbr] >= tin[node] and parent != -1:
                        mark[node] = True
                    children += 1
                else:
                    low[node] = min(low[node], tin[nbr])
            
            if parent == -1 and children > 1:
                mark[node] = True

        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        tin = [0] * V
        low = [0] * V
        vis = [False] * V
        mark = [False] * V

        for i in range(V):
            if not vis[i]:
                dfs(i, -1)

        res = [i for i in range(V) if mark[i]]
        return res if res else [-1]
