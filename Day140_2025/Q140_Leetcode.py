from typing import List


class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        n = len(nums)
        delta = [0] * (n + 1)

        for left, right in queries:
            delta[left] += 1
            if right + 1 < len(delta):
                delta[right + 1] -= 1

        current = 0
        operationCounts = []
        for d in delta[:-1]:
            current += d
            operationCounts.append(current)

        for i in range(n):
            if operationCounts[i] < nums[i]:
                return False

        return True
