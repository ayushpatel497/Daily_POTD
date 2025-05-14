from typing import List

MOD = 10**9 + 7
L = 26

class Solution:
    def identity(self):
        mat = [[0]*L for _ in range(L)]
        for i in range(L):
            mat[i][i] = 1
        return mat

    def multiply(self, a, b):
        res = [[0]*L for _ in range(L)]
        for i in range(L):
            for j in range(L):
                for k in range(L):
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD
        return res

    def quickmul(self, mat, exp):
        res = self.identity()
        while exp:
            if exp & 1:
                res = self.multiply(res, mat)
            mat = self.multiply(mat, mat)
            exp >>= 1
        return res

    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        T = [[0]*L for _ in range(L)]
        for i in range(L):
            for j in range(1, nums[i]+1):
                T[(i + j) % L][i] = 1

        res = self.quickmul(T, t)

        freq = [0]*L
        for ch in s:
            freq[ord(ch) - ord('a')] += 1

        ans = 0
        for i in range(L):
            for j in range(L):
                ans = (ans + res[i][j] * freq[j]) % MOD

        return ans
