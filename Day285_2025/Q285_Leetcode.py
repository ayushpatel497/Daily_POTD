from typing import List


class Solution:
    def magicalSum(self, m: int, k: int, nums: List[int]) -> int:
        MOD = 10**9 + 7

        def quickmul(x, y, mod):
            res, cur = 1, x % mod
            while y:
                if y & 1:
                    res = res * cur % mod
                y >>= 1
                cur = cur * cur % mod
            return res

        n = len(nums)
        fac = [1] * (m + 1)
        for i in range(1, m + 1):
            fac[i] = fac[i - 1] * i % MOD

        ifac = [1] * (m + 1)
        for i in range(2, m + 1):
            ifac[i] = quickmul(i, MOD - 2, MOD)
        for i in range(2, m + 1):
            ifac[i] = ifac[i - 1] * ifac[i] % MOD

        numsPower = [[1] * (m + 1) for _ in range(n)]
        for i in range(n):
            for j in range(1, m + 1):
                numsPower[i][j] = numsPower[i][j - 1] * nums[i] % MOD

        f = [[[[0] * (k + 1) for _ in range(m * 2 + 1)] for _ in range(m + 1)] for _ in range(n)]

        for j in range(m + 1):
            f[0][j][j][0] = numsPower[0][j] * ifac[j] % MOD

        for i in range(n - 1):
            for j in range(m + 1):
                for p in range(m * 2 + 1):
                    for q in range(k + 1):
                        q2 = (p % 2) + q
                        if q2 > k:
                            break
                        for r in range(m - j + 1):
                            p2 = (p // 2) + r
                            f[i + 1][j + r][p2][q2] = (f[i + 1][j + r][p2][q2] +
                                f[i][j][p][q] * numsPower[i + 1][r] % MOD * ifac[r] % MOD) % MOD

        res = 0
        for p in range(m * 2 + 1):
            for q in range(k + 1):
                if bin(p).count("1") + q == k:
                    res = (res + f[n - 1][m][p][q] * fac[m]) % MOD

        return res % MOD
