class Solution:
    def maxProfit(self, prices):
        buy1 = float('inf')
        buy2 = float('inf')
        profit1 = 0
        profit2 = 0
        
        for price in prices:
            buy1 = min(buy1, price)  # Min price for first buy
            profit1 = max(profit1, price - buy1)  # Max profit after first sell
            buy2 = min(buy2, price - profit1)  # Min cost for second buy
            profit2 = max(profit2, price - buy2)  # Max profit after second sell
        
        return profit2
