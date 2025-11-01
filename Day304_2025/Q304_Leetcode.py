import math
from typing import List

class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums) - 2
        total_sum = sum(nums)
        squared_sum = sum(x * x for x in nums)

        expected_sum = n * (n - 1) // 2
        expected_squared_sum = n * (n - 1) * (2 * n - 1) // 6

        sum2 = total_sum - expected_sum
        squared_sum2 = squared_sum - expected_squared_sum

        sqrt_val = math.sqrt(2 * squared_sum2 - sum2 * sum2)
        x1 = int((sum2 - sqrt_val) / 2)
        x2 = int((sum2 + sqrt_val) / 2)

        return [x1, x2]
