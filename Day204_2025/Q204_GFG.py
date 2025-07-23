class Solution:
    def subarraySum(self, arr):
        n = len(arr)
        total = 0

        for i in range(n):
            start = i + 1
            end = n - i
            contribution = start * end
            total += arr[i] * contribution

        return total
