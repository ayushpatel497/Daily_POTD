from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        ans = 0
        minPos = maxPos = leftBound = -1
        
        for i, num in enumerate(nums):
            if num < minK or num > maxK:
                leftBound = i
            if num == minK:
                minPos = i
            if num == maxK:
                maxPos = i
            count = min(minPos, maxPos) - leftBound
            ans += 0 if count <= 0 else count
        
        return ans
