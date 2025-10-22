import heapq

class Solution:
    def nearlySorted(self, arr, k):
        # Q. Nearly Sorted
        pq = []
        n = len(arr)

        # Insert first k elements
        for i in range(k):
            heapq.heappush(pq, arr[i])

        index = 0

        # Process remaining elements
        for i in range(k, n):
            heapq.heappush(pq, arr[i])
            arr[index] = heapq.heappop(pq)
            index += 1

        # Empty the remaining elements
        while pq:
            arr[index] = heapq.heappop(pq)
            index += 1
