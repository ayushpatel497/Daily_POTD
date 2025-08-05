class Solution:
    def numOfUnplacedFruits(self, fruits, baskets):
        count = 0
        n = len(baskets)

        for fruit in fruits:
            unset = True
            for i in range(n):
                if fruit <= baskets[i]:
                    baskets[i] = 0
                    unset = False
                    break
            if unset:
                count += 1

        return count
