from typing import List

class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        left, right = 0, max(candies)

        while left < right:
            mid = left + (right - left + 1) // 2  # Upper mid to prevent infinite loops

            if self.isValid(candies, k, mid):
                left = mid  # Increase lower bound if valid
            else:
                right = mid - 1  # Decrease upper bound if invalid

        return left

    def isValid(self, candies: List[int], k: int, mid: int) -> bool:
        if mid == 0:
            return False  # Avoid division by zero

        maxNumOfChildren = sum(candy // mid for candy in candies)

        return maxNumOfChildren >= k
