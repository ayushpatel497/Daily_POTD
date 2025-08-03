from typing import List


class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        n = len(fruits)
        left = 0
        right = 0
        sum_fruits = 0
        ans = 0

        def step(l, r):
            if fruits[r][0] <= startPos:
                return startPos - fruits[l][0]
            elif fruits[l][0] >= startPos:
                return fruits[r][0] - startPos
            else:
                return min(abs(startPos - fruits[r][0]), abs(startPos - fruits[l][0])) + fruits[r][0] - fruits[l][0]

        while right < n:
            sum_fruits += fruits[right][1]
            while left <= right and step(left, right) > k:
                sum_fruits -= fruits[left][1]
                left += 1
            ans = max(ans, sum_fruits)
            right += 1

        return ans
