from typing import List

class Solution:
    def maxProfit(self, n: int, present: List[int], future: List[int],
                  hierarchy: List[List[int]], budget: int) -> int:

        g = [[] for _ in range(n)]
        for u, v in hierarchy:
            g[u - 1].append(v - 1)

        def dfs(u):
            cost = present[u]
            dcost = cost // 2

            sub0 = [0] * (budget + 1)
            sub1 = [0] * (budget + 1)
            size = cost

            for v in g[u]:
                dp0v, dp1v, vsize = dfs(v)
                size += vsize
                nsub0 = [0] * (budget + 1)
                nsub1 = [0] * (budget + 1)

                for i in range(budget + 1):
                    for j in range(min(i, vsize) + 1):
                        nsub0[i] = max(nsub0[i], sub0[i - j] + dp0v[j])
                        nsub1[i] = max(nsub1[i], sub1[i - j] + dp1v[j])

                sub0, sub1 = nsub0, nsub1

            dp0 = [0] * (budget + 1)
            dp1 = [0] * (budget + 1)

            for i in range(budget + 1):
                dp0[i] = dp1[i] = sub0[i]

                if i >= dcost:
                    dp1[i] = max(dp1[i], sub1[i - dcost] + future[u] - dcost)
                if i >= cost:
                    dp0[i] = max(dp0[i], sub1[i - cost] + future[u] - cost)

            return dp0, dp1, size

        return dfs(0)[0][budget]
