from typing import List

class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        pos_count = 0
        neg_count = 0
        left, right = 0, len(nums) - 1

        # Count negatives using binary search
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] >= 0:
                right = mid - 1
            else:
                left = mid + 1
                neg_count = mid + 1

        left, right = 0, len(nums) - 1

        # Count positives using binary search
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] <= 0:
                left = mid + 1
            else:
                right = mid - 1
                pos_count = len(nums) - mid

        return max(pos_count, neg_count)
