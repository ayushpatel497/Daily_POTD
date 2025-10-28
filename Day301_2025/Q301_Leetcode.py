from typing import List

class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        total = sum(nums)
        left_sum, right_sum = 0, total

        for i in range(n):
            if nums[i] == 0:
                if 0 <= left_sum - right_sum <= 1:
                    ans += 1
                if 0 <= right_sum - left_sum <= 1:
                    ans += 1
            else:
                left_sum += nums[i]
                right_sum -= nums[i]

        return ans
