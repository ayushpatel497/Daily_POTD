from typing import List


class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        evenDigitCount = 0

        for num in nums:
            if len(str(num)) % 2 == 0:
                evenDigitCount += 1

        return evenDigitCount
