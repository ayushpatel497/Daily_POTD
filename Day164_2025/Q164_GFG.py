import math

class Solution:
    def calcuth(self, arr, hour):
        total = 0
        for bananas in arr:
            total += math.ceil(bananas / hour)
        return total

    def kokoEat(self, arr, k):
        low, high = 1, max(arr)
        while low <= high:
            mid = (low + high) // 2
            totalh = self.calcuth(arr, mid)
            if totalh <= k:
                high = mid - 1
            else:
                low = mid + 1
        return low
