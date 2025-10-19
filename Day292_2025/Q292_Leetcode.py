from math import gcd

class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        n = len(s)
        res = s
        s = s + s
        g = gcd(b, n)

        def add(t, start):
            t = list(t)
            min_val = 10
            times = 0
            for i in range(10):
                added = (int(t[start]) + i * a) % 10
                if added < min_val:
                    min_val = added
                    times = i
            for i in range(start, n, 2):
                t[i] = str((int(t[i]) + times * a) % 10)
            return ''.join(t)

        for i in range(0, n, g):
            t = s[i:i + n]
            t = add(t, 1)
            if b % 2:
                t = add(t, 0)
            res = min(res, t)
        return res
