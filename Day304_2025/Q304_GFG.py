class Solution:
    def dfs(self, node, adj, vis, prev, ans):
        vis[node] = prev
        for i in adj[node]:
            if vis[i] == 0:
                self.dfs(i, adj, vis, prev + 1, ans)
            elif vis[node] - vis[i] > 1:
                cycle_len = vis[node] - vis[i] + 1
                if ans[0] == -1:
                    ans[0] = cycle_len
                else:
                    ans[0] = min(ans[0], cycle_len)
            elif vis[node] + 1 < vis[i]:
                self.dfs(i, adj, vis, prev + 1, ans)

    def shortCycle(self, V, edges):
        ans = [-1]
        adj = [[] for _ in range(V)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        vis = [0] * V
        for i in range(V):
            if vis[i] == 0 and adj[i]:
                self.dfs(i, adj, vis, 1, ans)
        return ans[0]
