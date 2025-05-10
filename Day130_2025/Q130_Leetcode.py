from typing import List


class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        sum1 = sum2 = 0
        zero1 = zero2 = 0

        for num in nums1:
            if num == 0:
                sum1 += 1
                zero1 += 1
            else:
                sum1 += num

        for num in nums2:
            if num == 0:
                sum2 += 1
                zero2 += 1
            else:
                sum2 += num

        if (zero1 == 0 and sum2 > sum1) or (zero2 == 0 and sum1 > sum2):
            return -1

        return max(sum1, sum2)
