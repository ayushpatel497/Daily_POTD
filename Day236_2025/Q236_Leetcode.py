from typing import List

class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        zero_count = 0
        longest_window = 0
        start = 0
        
        for i, num in enumerate(nums):
            if num == 0:
                zero_count += 1
                
            while zero_count > 1:
                if nums[start] == 0:
                    zero_count -= 1
                start += 1
                
            longest_window = max(longest_window, i - start)
        
        return longest_window
