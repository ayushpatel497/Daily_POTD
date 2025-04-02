from typing import List

class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        imax = 0
        dmax = 0

        for k in range(n):
            res = max(res, dmax * nums[k])
            dmax = max(dmax, imax - nums[k])
            imax = max(imax, nums[k])

        return res

# Example Usage
sol = Solution()
nums = [10, 20, 5, 8, 12]
print(sol.maximumTripletValue(nums))  # Output: Maximum triplet value
