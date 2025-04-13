class Solution:
    MOD = 10**9 + 7

    def countGoodNumbers(self, n: int) -> int:
        return (self.mod_pow(5, (n + 1) // 2) * self.mod_pow(4, n // 2)) % self.MOD

    def mod_pow(self, base: int, exp: int) -> int:
        result = 1
        base %= self.MOD
        while exp > 0:
            if exp % 2 == 1:
                result = (result * base) % self.MOD
            base = (base * base) % self.MOD
            exp //= 2
        return result
