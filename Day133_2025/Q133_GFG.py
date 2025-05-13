import math

class Solution:
    def nCr(self, n, r):
        if r > n:
            return 0
        if r == 0 or n == r:
            return 1

        res = 0.0
        for i in range(r):
            res += math.log(n - i) - math.log(i + 1)

        return round(math.exp(res))
