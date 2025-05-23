from typing import List


class Solution:
    def maximumValueSum(self, nums: List[int], k: int, edges: List[List[int]]) -> int:
        total = 0
        count = 0
        positive_min = 1 << 30
        negative_max = -(1 << 30)

        for val in nums:
            operated = val ^ k
            total += val
            net_change = operated - val

            if net_change > 0:
                positive_min = min(positive_min, net_change)
                total += net_change
                count += 1
            else:
                negative_max = max(negative_max, net_change)

        if count % 2 == 0:
            return total

        return max(total - positive_min, total + negative_max)
