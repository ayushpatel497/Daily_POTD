class Solution:
    def findMissing(self, arr):
        n = len(arr)
        d = float('inf')

        # Find the minimum common difference
        for i in range(1, n):
            d = min(d, arr[i] - arr[i - 1])

        # Identify the missing element using the difference
        for i in range(1, n):
            if arr[i] - arr[i - 1] != d:
                return arr[i - 1] + d

        # If not found in loop, it's at the end
        return arr[-1] + d
