import math

class Solution:
    def isPossible(self, arr, k, val):
        total = 0
        for num in arr:
            total += math.ceil(num / val)
        return total <= k

    def smallestDivisor(self, arr, k):
        start = 1
        end = max(arr)
        ans = -1

        while start <= end:
            mid = (start + end) // 2
            if self.isPossible(arr, k, mid):
                ans = mid
                end = mid - 1
            else:
                start = mid + 1
        return ans
