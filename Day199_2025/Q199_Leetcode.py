import heapq
from typing import List

class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        n3 = len(nums)
        n = n3 // 3

        part1 = [0] * (n + 1)
        sum1 = 0
        max_heap = []

        for i in range(n):
            sum1 += nums[i]
            heapq.heappush(max_heap, -nums[i])  # simulate max heap using negation
        part1[0] = sum1

        for i in range(n, 2 * n):
            sum1 += nums[i]
            heapq.heappush(max_heap, -nums[i])
            sum1 += heapq.heappop(max_heap)  # subtract the largest (negative because of negation)
            part1[i - n + 1] = sum1

        sum2 = 0
        min_heap = []

        for i in range(n3 - 1, 2 * n - 1, -1):
            sum2 += nums[i]
            heapq.heappush(min_heap, nums[i])

        ans = part1[n] - sum2

        for i in range(2 * n - 1, n - 1, -1):
            sum2 += nums[i]
            heapq.heappush(min_heap, nums[i])
            sum2 -= heapq.heappop(min_heap)
            ans = min(ans, part1[i - n] - sum2)

        return ans
