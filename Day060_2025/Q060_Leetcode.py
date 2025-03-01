from typing import List

class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        n = len(nums)
        write_index = 0

        for index in range(n):
            if index < n - 1 and nums[index] == nums[index + 1] and nums[index] != 0:
                nums[index] *= 2
                nums[index + 1] = 0
            
            if nums[index] != 0:
                if index != write_index:
                    nums[index], nums[write_index] = nums[write_index], nums[index]
                write_index += 1
        
        return nums
