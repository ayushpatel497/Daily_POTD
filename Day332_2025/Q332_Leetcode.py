from typing import List


class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        self.count = 1  # root component

        def dfs(u, parent):
            total = 0

            for v in adj[u]:
                if v != parent:
                    child = dfs(v, u)
                    if child % k == 0:
                        self.count += 1
                    total = (total + child) % k

            return (total + values[u]) % k

        dfs(0, -1)
        return self.count
