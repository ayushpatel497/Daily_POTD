from typing import List

class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        maximum_ascending_sum = nums[0]
        current_ascending_sum = nums[0]

        for index in range(1, len(nums)):
            if nums[index] > nums[index - 1]:
                current_ascending_sum += nums[index]
            else:
                maximum_ascending_sum = max(maximum_ascending_sum, current_ascending_sum)
                current_ascending_sum = nums[index]

        return max(maximum_ascending_sum, current_ascending_sum)
