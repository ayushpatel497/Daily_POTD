class Solution:
    def minCost(self, n: int, m: int, x: list[int], y: list[int]) -> int:
        x.sort(reverse=True)
        y.sort(reverse=True)

        horizontalPieces = 1
        verticalPieces = 1
        i = 0
        j = 0
        totalCost = 0
        mod = 10**9 + 7  # Optional modulo

        while i < len(x) and j < len(y):
            if x[i] > y[j]:
                totalCost = (totalCost + x[i] * horizontalPieces) % mod
                verticalPieces += 1
                i += 1
            else:
                totalCost = (totalCost + y[j] * verticalPieces) % mod
                horizontalPieces += 1
                j += 1

        while i < len(x):
            totalCost = (totalCost + x[i] * horizontalPieces) % mod
            i += 1

        while j < len(y):
            totalCost = (totalCost + y[j] * verticalPieces) % mod
            j += 1

        return totalCost
