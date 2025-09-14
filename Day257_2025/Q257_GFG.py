class Solution:
    def startStation(self, gas: list[int], cost: list[int]) -> int:
        n = len(gas)
        totalCost = sum(cost)
        totalGas = sum(gas)

        if totalCost > totalGas:
            return -1

        start = 0
        profit = 0

        for i in range(n):
            profit += (gas[i] - cost[i])
            if profit < 0:
                start = (i + 1) % n
                profit = 0

        return start
