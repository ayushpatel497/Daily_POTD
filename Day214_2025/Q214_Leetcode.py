from collections import Counter
from typing import List

class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        freq = Counter()
        m = float('inf')

        for b1 in basket1:
            freq[b1] += 1
            m = min(m, b1)

        for b2 in basket2:
            freq[b2] -= 1
            m = min(m, b2)

        merge = []
        for fruit, count in freq.items():
            if count % 2 != 0:
                return -1
            merge.extend([fruit] * (abs(count) // 2))

        merge.sort()
        half = len(merge) // 2
        return sum(min(2 * m, merge[i]) for i in range(half))
