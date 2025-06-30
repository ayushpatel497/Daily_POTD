from typing import List


class Solution:
    def findLHS(self, nums: List[int]) -> int:
        from collections import Counter
        freq = Counter(nums)
        res = 0

        for key in freq:
            if key + 1 in freq:
                res = max(res, freq[key] + freq[key + 1])
        
        return res
