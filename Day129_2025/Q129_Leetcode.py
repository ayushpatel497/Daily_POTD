from typing import List
MOD = 10**9 + 7

class Solution:
    def countBalancedPermutations(self, num: str) -> int:
        n = len(num)
        total = sum(int(ch) for ch in num)
        if total % 2 != 0:
            return 0
        target = total // 2
        max_odd = (n + 1) // 2
        cnt = [0] * 10
        for ch in num:
            cnt[int(ch)] += 1

        # Precompute combinations
        comb = [[0] * (max_odd + 1) for _ in range(max_odd + 1)]
        for i in range(max_odd + 1):
            comb[i][0] = comb[i][i] = 1
            for j in range(1, i):
                comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % MOD

        f = [[0] * (max_odd + 1) for _ in range(target + 1)]
        f[0][0] = 1

        psum = 0
        totSum = 0

        for d in range(10):
            c = cnt[d]
            if c == 0:
                continue
            psum += c
            totSum += d * c

            for odd in range(min(psum, max_odd), max(0, psum - (n - max_odd)) - 1, -1):
                even = psum - odd
                for s in range(min(totSum, target), max(0, totSum - target) - 1, -1):
                    res = 0
                    for j in range(max(0, c - even), min(c, odd) + 1):
                        if d * j > s:
                            continue
                        ways = comb[odd][j] * comb[even][c - j] % MOD
                        res = (res + ways * f[s - d * j][odd - j]) % MOD
                    f[s][odd] = res

        return f[target][max_odd]
