from typing import List


class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        from collections import defaultdict
        count = defaultdict(int)
        count[0] = 1
        res = 0
        prefix = 0

        for num in nums:
            if num % modulo == k:
                prefix += 1
            key = (prefix - k + modulo) % modulo
            res += count[key]
            count[prefix % modulo] += 1

        return res