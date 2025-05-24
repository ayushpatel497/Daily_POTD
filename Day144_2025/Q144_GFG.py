class Solution:
    def sumSubstrings(self, s: str) -> int:
        sum_ = 0
        mf = 1
        mod = 10**9 + 7  # Use modulus if required

        for i in range(len(s) - 1, -1, -1):
            digit = int(s[i])
            sum_ = (sum_ + digit * (i + 1) * mf) % mod
            mf = (mf * 10 + 1) % mod

        return sum_
