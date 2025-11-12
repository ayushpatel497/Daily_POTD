from math import gcd
from typing import List

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        num1 = 0
        g = 0

        for x in nums:
            if x == 1:
                num1 += 1
            g = gcd(g, x)

        if num1 > 0:
            return n - num1
        if g > 1:
            return -1

        min_len = n
        for i in range(n):
            curr_g = 0
            for j in range(i, n):
                curr_g = gcd(curr_g, nums[j])
                if curr_g == 1:
                    min_len = min(min_len, j - i + 1)
                    break

        return min_len + n - 2
