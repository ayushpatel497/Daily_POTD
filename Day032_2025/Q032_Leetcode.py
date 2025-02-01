from typing import List

class Solution:
    def isOdd(self, number: int) -> bool:
        return number & 1

    def isArraySpecial(self, nums: List[int]) -> bool:
        numsSize = len(nums)
        if numsSize == 1:
            return True
        
        for i in range(1, numsSize):
            if (self.isOdd(nums[i]) and self.isOdd(nums[i - 1])) or (not self.isOdd(nums[i]) and not self.isOdd(nums[i - 1])):
                return False
        
        return True
