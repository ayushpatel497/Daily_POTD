class Solution:
    def maxAdjacentDistance(self, nums):
        n = len(nums)
        res = abs(nums[0] - nums[-1])
        for i in range(n - 1):
            res = max(res, abs(nums[i] - nums[i + 1]))
        return res
