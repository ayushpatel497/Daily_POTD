from typing import List


class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        self.count = 0
        maxOR = 0
        for num in nums:
            maxOR |= num

        def backtrack(index, currentOR):
            if index == len(nums):
                if currentOR == maxOR:
                    self.count += 1
                return
            backtrack(index + 1, currentOR | nums[index])  # Include
            backtrack(index + 1, currentOR)                # Exclude

        backtrack(0, 0)
        return self.count
