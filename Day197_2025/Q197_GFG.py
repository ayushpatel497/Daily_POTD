class Solution:
    def sieve(self, n):
        is_prime = [True] * n
        is_prime[0] = is_prime[1] = False
        for i in range(2, n):
            if is_prime[i]:
                for j in range(i * i, n, i):
                    is_prime[j] = False
        return [i for i, val in enumerate(is_prime) if val]

    def countNumbers(self, n):
        from math import isqrt
        count = 0
        primes = self.sieve(isqrt(n) + 1)

        for p in primes:
            if p ** 8 <= n:
                count += 1
            else:
                break

        for i in range(len(primes)):
            for j in range(i + 1, len(primes)):
                val = primes[i] ** 2 * primes[j] ** 2
                if val <= n:
                    count += 1
                else:
                    break

        return count
