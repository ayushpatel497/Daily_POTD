from typing import List

class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        sum_ = 0
        k = 0
        differenceArray = [0] * (n + 1)

        for index in range(n):
            while sum_ + differenceArray[index] < nums[index]:
                k += 1
                if k > len(queries):
                    return -1
                
                left, right, val = queries[k - 1]
                
                if right >= index:
                    differenceArray[max(left, index)] += val
                    differenceArray[right + 1] -= val
            
            sum_ += differenceArray[index]

        return k
