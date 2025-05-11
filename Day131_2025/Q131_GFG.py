import heapq

class Solution:
    def kthLargest(self, arr, k) -> int:
        n = len(arr)
        min_heap = []
        
        for i in range(n):
            s = 0
            for j in range(i, n):
                s += arr[j]
                heapq.heappush(min_heap, s)
                if len(min_heap) > k:
                    heapq.heappop(min_heap)
        
        return min_heap[0]
