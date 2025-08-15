import math

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n == 1:
            return True
        if n <= 0:
            return False
        log_base4 = math.log(n) / math.log(4)
        return log_base4 == int(log_base4)
