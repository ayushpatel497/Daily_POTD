from typing import List
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False
        target = total // 2

        prev = [False] * (target + 1)
        curr = [False] * (target + 1)
        prev[0] = True
        curr[0] = True

        for i in reversed(range(len(nums))):
            for t in range(target + 1):
                include = prev[t - nums[i]] if t - nums[i] >= 0 else False
                exclude = prev[t]
                curr[t] = include or exclude
            prev = curr[:]

        return prev[target]
