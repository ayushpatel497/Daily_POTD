import heapq

class Solution:
    def minOperations(self, arr):
        pq = [-x for x in arr]  # max-heap using negatives
        heapq.heapify(pq)

        arr_sum = sum(arr)
        target = arr_sum / 2
        count = 0

        while arr_sum > target:
            largest = -heapq.heappop(pq)
            half = largest / 2
            arr_sum -= half
            heapq.heappush(pq, -half)
            count += 1

        return count
