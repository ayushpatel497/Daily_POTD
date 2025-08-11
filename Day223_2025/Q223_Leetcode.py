from typing import List


class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7

        # Step 1: Extract powers of two from n
        bins = []
        rep = 1
        while n > 0:
            if n % 2 == 1:
                bins.append(rep)
            n //= 2
            rep *= 2

        # Step 2: Precompute products for all ranges
        m = len(bins)
        results = [[0] * m for _ in range(m)]
        for i in range(m):
            cur = 1
            for j in range(i, m):
                cur = (cur * bins[j]) % MOD
                results[i][j] = cur

        # Step 3: Answer queries
        ans = []
        for l, r in queries:
            ans.append(results[l][r])
        return ans
