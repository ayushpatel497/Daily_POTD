import heapq
from typing import List

class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        # max heap using negative values
        pq = [-h for h in happiness]
        heapq.heapify(pq)

        total = 0
        turns = 0

        for _ in range(k):
            top = -heapq.heappop(pq)
            total += max(top - turns, 0)
            turns += 1

        return total
