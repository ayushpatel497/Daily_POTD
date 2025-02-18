import heapq
from typing import List

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # Max-heap to store k closest points
        maxHeap = []

        for x, y in points:
            dist = -(x * x + y * y)  # Use negative distance to simulate max-heap
            if len(maxHeap) < k:
                heapq.heappush(maxHeap, (dist, x, y))
            elif dist > maxHeap[0][0]:  # If new distance is smaller, replace the farthest
                heapq.heappop(maxHeap)
                heapq.heappush(maxHeap, (dist, x, y))

        # Extract k closest points
        return [[x, y] for (_, x, y) in maxHeap]
