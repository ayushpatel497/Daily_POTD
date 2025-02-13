import heapq
from typing import List

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        min_heap = nums[:]
        heapq.heapify(min_heap)  # Convert list into a min-heap
        count = 0

        while min_heap[0] < k:
            first = heapq.heappop(min_heap)
            second = heapq.heappop(min_heap)
            count += 1

            doubled_min = min(first, second) * 2
            val = doubled_min if doubled_min >= k else doubled_min + max(first, second)

            heapq.heappush(min_heap, val)
        
        return count
