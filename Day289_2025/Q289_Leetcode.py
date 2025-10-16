from typing import List


class Solution:
    def findSmallestInteger(self, nums: List[int], value: int) -> int:
        freq = [0] * value
        
        # Count frequency of each remainder
        for x in nums:
            v = (x % value + value) % value  # handle negatives
            freq[v] += 1
        
        res = 0
        while freq[res % value] > 0:
            freq[res % value] -= 1
            res += 1
        
        return res
