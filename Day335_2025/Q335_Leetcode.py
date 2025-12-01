from typing import List


class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:

        sumPower = sum(batteries)
        left, right = 1, sumPower // n

        while left < right:
            target = right - (right - left) // 2
            extra = 0

            for power in batteries:
                extra += min(power, target)

            if extra >= n * target:
                left = target
            else:
                right = target - 1

        return left
