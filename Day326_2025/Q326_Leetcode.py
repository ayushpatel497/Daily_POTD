from typing import List


class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        ans = 0
        for v in nums:
            mod = v % 3
            ans += min(mod, 3 - mod)
        return ans
