class Solution:
    def maxProfit(self, arr):
        n = len(arr)
        if n == 0:
            return 0
        
        dp0 = 0           # rest (not holding)
        dp1 = -arr[0]     # holding a stock
        dp2 = 0           # cooldown (just sold)
        
        for i in range(1, n):
            price = arr[i]
            prev0, prev1, prev2 = dp0, dp1, dp2

            dp0 = max(prev0, prev2)
            dp1 = max(prev1, prev0 - price)
            dp2 = prev1 + price
        
        return int(max(dp0, dp2))
