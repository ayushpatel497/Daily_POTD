class Solution:
    def kLengthApart(self, nums, k: int) -> bool:
        prev = -1
        first = True

        for i, val in enumerate(nums):
            if first and val == 1:
                prev = i
                first = False
            elif val == 1:
                if i - prev - 1 < k:
                    return False
                prev = i
        
        return True
