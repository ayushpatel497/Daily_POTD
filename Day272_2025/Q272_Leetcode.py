from typing import List


class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        from functools import lru_cache
        n = len(values)

        @lru_cache(None)
        def dp(i, j):
            if i + 2 > j:
                return 0
            if i + 2 == j:
                return values[i] * values[i + 1] * values[j]
            
            min_score = float("inf")
            for k in range(i + 1, j):
                min_score = min(min_score, values[i] * values[k] * values[j] 
                                             + dp(i, k) + dp(k, j))
            return min_score

        return dp(0, n - 1)
