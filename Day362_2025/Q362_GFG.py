import math

class Solution:
    def minTime(self, ranks, n):
        
        def numberOfDonuts(t):
            donuts = 0
            for r in ranks:
                donuts += int((math.sqrt(1 + 8 * t / r) - 1) // 2)
            return donuts

        low = 0
        min_rank = min(ranks)
        high = n * (n + 1) // 2 * min_rank
        ans = high

        while low <= high:
            mid = low + (high - low) // 2
            if numberOfDonuts(mid) >= n:
                ans = mid
                high = mid - 1
            else:
                low = mid + 1

        return ans
