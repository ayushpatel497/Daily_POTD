import heapq
from typing import List

class Solution:
    def getMedian(self, arr: List[int]) -> List[float]:
        left_max_heap = []  # Python heapq is a min-heap, so we use negatives to simulate a max-heap
        right_min_heap = []
        ans = []
        
        for num in arr:
            # Add new number to left heap (as negative to simulate max-heap)
            heapq.heappush(left_max_heap, -num)
            
            # Balance: move the largest element from left to right
            heapq.heappush(right_min_heap, -heapq.heappop(left_max_heap))
            
            # Maintain size property
            if len(right_min_heap) > len(left_max_heap):
                heapq.heappush(left_max_heap, -heapq.heappop(right_min_heap))
            
            # Compute median based on heap sizes
            if len(left_max_heap) > len(right_min_heap):
                median = -left_max_heap[0]
            else:
                median = (-left_max_heap[0] + right_min_heap[0]) / 2.0
            ans.append(median)
        
        return ans
