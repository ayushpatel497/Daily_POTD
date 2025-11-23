from typing import List


class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        f = [0, float('-inf'), float('-inf')]

        for num in nums:
            g = f[:]  # clone
            rem = num % 3

            for i in range(3):
                new_rem = (i + rem) % 3
                g[new_rem] = max(g[new_rem], f[i] + num)

            f = g

        return f[0]
