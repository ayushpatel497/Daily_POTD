class Solution:
    def maxSubarraySum(self, nums, k: int) -> int:
        n = len(nums)
        prefixSum = 0
        maxSum = float("-inf")

        kSum = [float("inf")] * k
        kSum[k - 1] = 0   # base case

        for i, num in enumerate(nums):
            prefixSum += num

            mod = i % k
            maxSum = max(maxSum, prefixSum - kSum[mod])

            kSum[mod] = min(kSum[mod], prefixSum)

        return maxSum
