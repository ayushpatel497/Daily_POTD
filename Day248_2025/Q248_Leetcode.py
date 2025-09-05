class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        for k in range(1, 61):  # 2^60 > 1e18, safe upper bound
            x = num1 - num2 * k
            if x < k:
                return -1
            if bin(x).count("1") <= k:
                return k
        return -1
