class Solution:
    def minCost(self, heights, cost):
        n = len(heights)
        idx = list(range(n))
        idx.sort(key=lambda i: heights[i])

        sufCost = sum(cost[i] for i in idx)
        sufProdSum = sum(heights[i] * cost[i] for i in idx)

        preCost = 0
        preProdSum = 0
        ans = float('inf')

        for i in range(n):
            h = heights[idx[i]]
            c = cost[idx[i]]

            preCost += c
            preProdSum += h * c
            sufCost -= c
            sufProdSum -= h * c

            totalCost = (h * preCost - preProdSum) + (sufProdSum - h * sufCost)
            ans = min(ans, totalCost)

        return int(ans)
