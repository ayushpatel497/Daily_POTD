class Solution:
    def dfs(self, node, parent, graph, k):
        if k < 0:
            return 0
        res = 1
        for child in graph[node]:
            if child != parent:
                res += self.dfs(child, node, graph, k - 1)
        return res

    def build(self, edges, k):
        n = len(edges) + 1
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        res = [0] * n
        for i in range(n):
            res[i] = self.dfs(i, -1, graph, k)
        return res

    def maxTargetNodes(self, edges1, edges2, k):
        n = len(edges1) + 1
        count1 = self.build(edges1, k)
        count2 = self.build(edges2, k - 1)
        maxCount2 = max(count2)
        return [c1 + maxCount2 for c1 in count1]
