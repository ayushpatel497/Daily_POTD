class Solution:
    def dfs(self, node, parent, depth, children, color):
        res = 1 - depth % 2
        color[node] = depth % 2
        for child in children[node]:
            if child != parent:
                res += self.dfs(child, node, depth + 1, children, color)
        return res

    def build(self, edges, color):
        n = len(edges) + 1
        children = [[] for _ in range(n)]
        for u, v in edges:
            children[u].append(v)
            children[v].append(u)
        count_even = self.dfs(0, -1, 0, children, color)
        return [count_even, n - count_even]

    def maxTargetNodes(self, edges1, edges2):
        n = len(edges1) + 1
        m = len(edges2) + 1
        color1 = [0] * n
        color2 = [0] * m

        count1 = self.build(edges1, color1)
        count2 = self.build(edges2, color2)

        max_count2 = max(count2[0], count2[1])
        return [count1[color1[i]] + max_count2 for i in range(n)]
