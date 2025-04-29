from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_element = max(nums)
        start = 0
        max_count = 0
        ans = 0

        for end in range(len(nums)):
            if nums[end] == max_element:
                max_count += 1

            while max_count == k:
                if nums[start] == max_element:
                    max_count -= 1
                start += 1

            ans += start

        return ans
