import bisect
from typing import List


class Solution:
    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        def count_leq(mid: int) -> int:
            count = 0
            pos1 = bisect.bisect_left(nums1, 0)
            pos2 = bisect.bisect_left(nums2, 0)

            # negative * positive
            i1, i2 = 0, pos2 - 1
            while i1 < pos1 and i2 >= 0:
                if nums1[i1] * nums2[i2] > mid:
                    i1 += 1
                else:
                    count += pos1 - i1
                    i2 -= 1

            # positive * positive
            i1, i2 = pos1, len(nums2) - 1
            while i1 < len(nums1) and i2 >= pos2:
                if nums1[i1] * nums2[i2] > mid:
                    i2 -= 1
                else:
                    count += i2 - pos2 + 1
                    i1 += 1

            # negative * negative
            i1, i2 = 0, pos2
            while i1 < pos1 and i2 < len(nums2):
                if nums1[i1] * nums2[i2] > mid:
                    i2 += 1
                else:
                    count += len(nums2) - i2
                    i1 += 1

            # positive * negative
            i1, i2 = pos1, 0
            while i1 < len(nums1) and i2 < pos2:
                if nums1[i1] * nums2[i2] > mid:
                    i1 += 1
                else:
                    count += len(nums1) - i1
                    i2 += 1

            return count

        nums1.sort()
        nums2.sort()
        left, right = -10**10, 10**10

        while left <= right:
            mid = (left + right) // 2
            if count_leq(mid) < k:
                left = mid + 1
            else:
                right = mid - 1

        return left
