class Solution:
    def maxCircularSum(self, arr):
        n = len(arr)
        totalSum = sum(arr)
        currMax = maxSum = arr[0]
        currMin = minSum = arr[0]

        for i in range(1, n):
            currMax = max(arr[i], currMax + arr[i])
            maxSum = max(maxSum, currMax)

            currMin = min(arr[i], currMin + arr[i])
            minSum = min(minSum, currMin)

        if maxSum < 0:
            return maxSum
        return max(maxSum, totalSum - minSum)
