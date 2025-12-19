class Solution:
    def findMoves(self, chairs, passengers):
        chairs.sort()
        passengers.sort()

        total = 0
        for c, p in zip(chairs, passengers):
            total += abs(p - c)

        return total
