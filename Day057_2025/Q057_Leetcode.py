from typing import List

class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        min_prefix_sum, max_prefix_sum = 0, 0
        prefix_sum = 0

        for num in nums:
            prefix_sum += num
            min_prefix_sum = min(min_prefix_sum, prefix_sum)
            max_prefix_sum = max(max_prefix_sum, prefix_sum)

        return max_prefix_sum - min_prefix_sum
