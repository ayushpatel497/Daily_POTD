import math
from functools import lru_cache

class Solution:
    def soupServings(self, n: int) -> float:
        m = math.ceil(n / 25)

        @lru_cache(None)
        def calculateDP(i, j):
            if i <= 0 and j <= 0:
                return 0.5
            if i <= 0:
                return 1.0
            if j <= 0:
                return 0.0
            return (
                calculateDP(i - 4, j) +
                calculateDP(i - 3, j - 1) +
                calculateDP(i - 2, j - 2) +
                calculateDP(i - 1, j - 3)
            ) / 4.0

        for k in range(1, m + 1):
            if calculateDP(k, k) > 1 - 1e-5:
                return 1.0
        return calculateDP(m, m)
