class Solution:
    def maxSum(self, arr):
        n = len(arr)
        ans = -1
        for i in range(1, n):
            temp = arr[i] + arr[i - 1]
            ans = max(ans, temp)
        return ans
