class Solution:
    def minMaxCandy(self, prices, k):
        ans = []
        prices.sort()
        
        elementUsed = 0
        totalSum = 0
        start = 0
        while elementUsed < len(prices):
            totalSum += prices[start]
            if k == 0:
                elementUsed += 1
            else:
                elementUsed = elementUsed + k + 1
            start += 1
        ans.append(totalSum)
        
        elementUsed = 0
        totalSum = 0
        end = len(prices) - 1
        while elementUsed < len(prices):
            totalSum += prices[end]
            if k == 0:
                elementUsed += 1
            else:
                elementUsed = elementUsed + k + 1
            end -= 1
        ans.append(totalSum)
        
        return ans
