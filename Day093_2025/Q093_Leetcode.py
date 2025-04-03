from typing import List

class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        res, imax, dmax = 0, 0, 0
        
        for k in range(n):
            res = max(res, dmax * nums[k])
            dmax = max(dmax, imax - nums[k])
            imax = max(imax, nums[k])
        
        return res

# Example Usage
sol = Solution()
nums = [3, 7, 1, 5, 9]
print(sol.maximumTripletValue(nums))  # Output: Maximum triplet value
