class Solution:
    def countSetBits(self, n):
        if n == 0:
            return 0

        x = 0
        while (1 << x) <= n:
            x += 1
        x -= 1

        a = x * (1 << (x - 1))
        b = n - (1 << x) + 1
        c = self.countSetBits(n - (1 << x))

        return a + b + c
