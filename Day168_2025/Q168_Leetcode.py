class Solution:
    MOD = 10**9 + 7
    MX = 10**5
    fact = [1] * MX
    inv_fact = [1] * MX
    initialized = False

    def init(self):
        if self.initialized:
            return
        self.initialized = True
        for i in range(1, self.MX):
            self.fact[i] = self.fact[i - 1] * i % self.MOD
        self.inv_fact[self.MX - 1] = pow(self.fact[self.MX - 1], self.MOD - 2, self.MOD)
        for i in range(self.MX - 2, -1, -1):
            self.inv_fact[i] = self.inv_fact[i + 1] * (i + 1) % self.MOD

    def comb(self, n, r):
        if r > n:
            return 0
        return self.fact[n] * self.inv_fact[r] % self.MOD * self.inv_fact[n - r] % self.MOD

    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        self.init()
        return self.comb(n - 1, k) * m % self.MOD * pow(m - 1, n - k - 1, self.MOD) % self.MOD
