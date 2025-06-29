from typing import List

class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        mod = 10**9 + 7
        nums.sort()
        n = len(nums)
        pow2 = [1] * (n + 1)
        for i in range(1, n + 1):
            pow2[i] = pow2[i - 1] * 2 % mod
        
        res = 0
        l, r = 0, n - 1
        while l <= r:
            if nums[l] + nums[r] > target:
                r -= 1
            else:
                res = (res + pow2[r - l]) % mod
                l += 1
        return res
