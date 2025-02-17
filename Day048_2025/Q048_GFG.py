import heapq

class Solution:
    def kLargest(self, arr, k):
        pq = []  # Min-heap
        
        # Add first k elements to the heap
        for i in range(k):
            heapq.heappush(pq, arr[i])

        # Process the remaining elements
        for i in range(k, len(arr)):
            if arr[i] > pq[0]:
                heapq.heappop(pq)
                heapq.heappush(pq, arr[i])

        # Extract k largest elements
        result = sorted(pq, reverse=True)
        return result
