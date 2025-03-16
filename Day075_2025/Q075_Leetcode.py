import heapq
from collections import Counter
from typing import List

class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        count = Counter(ranks)
        min_heap = []
        
        for rank, mech_count in count.items():
            heapq.heappush(min_heap, [rank, rank, 1, mech_count])

        time = 0
        while cars > 0:
            current = heapq.heappop(min_heap)
            time = current[0]
            rank = current[1]
            n = current[2]
            mech_count = current[3]

            cars -= mech_count
            n += 1
            heapq.heappush(min_heap, [rank * n * n, rank, n, mech_count])

        return time
