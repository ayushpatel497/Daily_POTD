import heapq
from typing import List

class Solution:
    def maxRemoval(self, nums: List[int], queries: List[List[int]]) -> int:
        queries.sort()  # sort by start index (i.e., queries[i][0])
        heap = []
        deltaArray = [0] * (len(nums) + 1)
        operations = 0
        j = 0

        for i in range(len(nums)):
            operations += deltaArray[i]
            while j < len(queries) and queries[j][0] == i:
                heapq.heappush(heap, -queries[j][1])  # max-heap by negating
                j += 1

            while operations < nums[i] and heap and -heap[0] >= i:
                right = -heapq.heappop(heap)
                operations += 1
                if right + 1 < len(deltaArray):
                    deltaArray[right + 1] -= 1

            if operations < nums[i]:
                return -1

        return len(heap)
