class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        totalBottles = numBottles
        while numBottles >= numExchange:
            emptyBottles = numBottles // numExchange
            totalBottles += emptyBottles
            numBottles = emptyBottles + (numBottles % numExchange)
        return totalBottles
