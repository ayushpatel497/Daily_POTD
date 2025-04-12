from math import factorial
from collections import Counter

class Solution:
    def countGoodIntegers(self, n: int, k: int) -> int:
        seen = set()
        base = 10 ** ((n - 1) // 2)
        skip = n % 2

        for i in range(base, base * 10):
            s = str(i)
            pal = s + s[::-1][skip:]
            pal_num = int(pal)
            if pal_num % k == 0:
                seen.add(''.join(sorted(pal)))

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i

        ans = 0
        for s in seen:
            cnt = Counter(map(int, s))
            total = (n - cnt[0]) * fact[n - 1]
            for x in cnt.values():
                total //= fact[x]
            ans += total

        return ans
