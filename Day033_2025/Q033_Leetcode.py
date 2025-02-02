from typing import List

class Solution:
    def check(self, nums: List[int]) -> bool:
        count, numsSize = 0, len(nums)

        for i in range(numsSize):
            if nums[i] > nums[(i + 1) % numsSize]:
                count += 1
                
        return count <= 1
