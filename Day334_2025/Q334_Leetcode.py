from typing import List


class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total = sum(nums) % p
        if total == 0:
            return 0

        need = total
        prefix = 0
        n = len(nums)
        seen = {0: -1}
        res = n

        for i, num in enumerate(nums):
            prefix = (prefix + num) % p
            target = (prefix - need + p) % p

            if target in seen:
                res = min(res, i - seen[target])

            seen[prefix] = i

        return -1 if res == n else res
