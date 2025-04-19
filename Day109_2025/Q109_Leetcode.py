from bisect import bisect_left
from typing import List

class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()
        return self.count_less_than(nums, upper + 1) - self.count_less_than(nums, lower)

    def count_less_than(self, nums: List[int], value: int) -> int:
        count = 0
        left, right = 0, len(nums) - 1
        while left < right:
            total = nums[left] + nums[right]
            if total < value:
                count += (right - left)
                left += 1
            else:
                right -= 1
        return count
